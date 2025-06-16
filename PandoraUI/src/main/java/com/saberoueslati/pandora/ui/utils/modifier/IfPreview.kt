package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode

/**
 * Applies a modifier conditionally only during preview (e.g., Android Studio Compose Preview).
 *
 * This is useful for applying UI tweaks or placeholder content visible only
 * during design-time previews without affecting runtime behavior.
 *
 * @param isPreview Modifier transformation to apply when in preview mode.
 * @return [Modifier] with the [isPreview] transformation applied only during preview, or unchanged otherwise.
 */
@Composable
fun Modifier.ifPreview(
    isPreview: @Composable Modifier.() -> Modifier
): Modifier {
    return if (LocalInspectionMode.current) {
        this.then(isPreview())
    } else this
}
