package com.saberoueslati.pandora.ui.designsystem.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView

/**
 * Keeps the screen on while this composable is in the composition.
 *
 * Useful for screens like video playback, training sessions, or long-running processes
 * where the user should not be interrupted by the device sleeping or dimming.
 */
@Composable
fun KeepScreenOn() {
    val currentView = LocalView.current
    DisposableEffect(Unit) {
        currentView.keepScreenOn = true
        onDispose {
            currentView.keepScreenOn = false
        }
    }
}
