package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Applies one of two modifier transformations based on a [condition].
 *
 * This is a composable extension function on [Modifier] that applies
 * [ifTrue] transformation when [condition] is `true`, or optionally
 * applies [ifFalse] transformation when [condition] is `false`.
 * If [ifFalse] is not provided and [condition] is false, the original
 * modifier is returned unchanged.
 *
 * @param condition The condition to evaluate.
 * @param ifTrue The modifier transformation to apply if [condition] is `true`.
 * @param ifFalse Optional modifier transformation to apply if [condition] is `false`.
 * @return The resulting [Modifier] after applying the appropriate transformation.
 */
@Composable
fun Modifier.conditional(
    condition: Boolean,
    ifTrue: @Composable Modifier.() -> Modifier,
    ifFalse: @Composable (Modifier.() -> Modifier)? = null
): Modifier {
    return if (condition) {
        then(ifTrue(Modifier))
    } else if (ifFalse != null) {
        then(ifFalse(Modifier))
    } else {
        this
    }
}
