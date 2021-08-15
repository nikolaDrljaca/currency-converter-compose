package com.drbrosdev.currencyconverter.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlin.reflect.KProperty1

/*
Extensions to help with state and event handling.
 */

/*
Uses kotlin reflection.
Usage: stateFlow.stateFrom(StateFlowDataClass::field)
 */
@Composable
fun <T, S> StateFlow<T>.stateFrom(prop: KProperty1<T, S>): State<S> =
    produceState(
        initialValue = prop.get(value),
        producer = { collect { value = prop.get(it) } }
    )

/*
Uses mapper lambda to grab fields as state from data classes.
Usage: stateFlow.stateFrom { it.field }
 */
@Composable
fun <T, S> StateFlow<T>.stateFrom(mapper: (T) -> S): State<S> =
    produceState(initialValue = mapper(value), producer = {
        collect { value = mapper(it) }
    })
