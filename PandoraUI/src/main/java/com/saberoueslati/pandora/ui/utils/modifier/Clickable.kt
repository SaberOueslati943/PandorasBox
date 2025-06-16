package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput

/**
 * Adds a clickable behavior to the [Modifier] without any visual indication (no ripple or highlight).
 *
 * This is useful when you want an element to respond to clicks but avoid showing any visual feedback.
 *
 * @param onClick Lambda to be invoked when the element is clicked.
 * @return [Modifier] with transparent clickable behavior applied.
 */
fun Modifier.transparentClickable(
    onClick: () -> Unit
): Modifier {
    return this.composed {
        this.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            onClick()
        }
    }
}

/**
 * Prevents click events from passing through the element to underlying components.
 *
 * This modifier consumes all tap gestures without triggering any action,
 * effectively blocking clicks from falling through.
 *
 * @return [Modifier] that intercepts and consumes all tap gestures.
 */
fun Modifier.preventFallthroughClicks(): Modifier = this.pointerInput(Unit) {
    detectTapGestures {
        // Consume the touch event but do nothing
    }
}
