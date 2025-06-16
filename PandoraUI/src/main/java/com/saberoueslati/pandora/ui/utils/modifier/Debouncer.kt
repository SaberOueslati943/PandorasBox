package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * Creates a debounced click handler that limits how frequently [onClick] can be invoked.
 *
 * When the returned lambda is called multiple times in quick succession, only
 * the first call after the [debounceInterval] delay will trigger [onClick].
 *
 * @param onClick The callback to invoke when the click is accepted.
 * @param debounceInterval The minimum interval (in milliseconds) between allowed clicks. Default is 1000ms.
 * @return A lambda to be called when a click happens, enforcing the debounce logic.
 */
@Composable
inline fun debounced(
    crossinline onClick: () -> Unit,
    debounceInterval: Long = 1000L
): () -> Unit {
    var lastTimeClicked by remember { mutableLongStateOf(0L) }
    val onClickLambda: () -> Unit = {
        val now = System.currentTimeMillis()
        if (now - lastTimeClicked > debounceInterval) {
            onClick()
        }
        lastTimeClicked = now
    }
    return onClickLambda
}

/**
 * Adds a clickable modifier that prevents multiple rapid clicks by applying a debounce interval.
 *
 * This ensures that [onClick] is not called more than once within the specified [debounceInterval].
 *
 * @param onClick The click event callback.
 * @param debounceInterval The debounce interval in milliseconds, default is 1000ms.
 * @return A [Modifier] that debounces clicks.
 */
fun Modifier.debouncedClickable(
    onClick: () -> Unit,
    debounceInterval: Long = 1000L
): Modifier {
    return this.composed {
        val clickable = debounced(debounceInterval = debounceInterval, onClick = { onClick() })
        this.clickable { clickable() }
    }
}

/**
 * Adds a transparent clickable modifier with debounce to prevent multiple rapid clicks.
 *
 * This modifier applies clickable behavior without any visual indication (no ripple),
 * and debounces clicks to avoid multiple triggers within [debounceInterval].
 *
 * @param onClick The click event callback.
 * @param debounceInterval The debounce interval in milliseconds, default is 1000ms.
 * @return A [Modifier] with transparent debounced click behavior.
 */
fun Modifier.debouncedClickableTransparent(
    onClick: () -> Unit,
    debounceInterval: Long = 1000L
): Modifier {
    return this.composed {
        val clickable = debounced(debounceInterval = debounceInterval, onClick = { onClick() })
        this.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) { clickable() }
    }
}