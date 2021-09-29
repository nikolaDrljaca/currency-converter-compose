package com.drbrosdev.currencyconverter.web

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceBuilder {

    private const val cacheSize = (5 * 1024 * 1024).toLong()
    private const val maxAge = 5
    private const val maxStale = (60 * 60 * 24 * 7)

    private const val baseUrl = "https://api.exchangerate.host/latest/"

    fun <T> buildService(service: Class<T>, context: Context): T {
        val myCache = Cache(context.cacheDir, cacheSize)
        val client = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context = context))
                /*
                  *  If there is Internet, get the cache that was stored 5 seconds ago.
                  *  If the cache is older than 5 seconds, then discard it,
                  *  and indicate an error in fetching the response.
                  *  The 'max-age' attribute is responsible for this behavior.
                  */
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, max-age=$maxAge"
                    ).build()
                else
                /*
                   *  If there is no Internet, get the cache that was stored 7 days ago.
                   *  If the cache is older than 7 days, then discard it,
                   *  and indicate an error in fetching the response.
                   *  The 'max-stale' attribute is responsible for this behavior.
                   *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
                   */
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=$maxStale"
                    ).build()
                chain.proceed(request)
            }
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        return retrofit.create(service)
    }

    private fun hasNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            //for deprecated version
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }

}