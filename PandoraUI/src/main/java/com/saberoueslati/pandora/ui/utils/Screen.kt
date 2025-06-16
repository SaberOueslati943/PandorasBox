package com.saberoueslati.pandora.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Utility object for retrieving screen dimensions in Compose.
 */
object Screen {

    /**
     * Returns the screen height in density-independent pixels (dp).
     *
     * @return Screen height in dp.
     */
    @Composable
    fun height(): Int {
        return LocalConfiguration.current.screenHeightDp
    }

    /**
     * Returns the screen width in density-independent pixels (dp).
     *
     * @return Screen width in dp.
     */
    @Composable
    fun width(): Int {
        return LocalConfiguration.current.screenWidthDp
    }
}
