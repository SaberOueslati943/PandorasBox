package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

/**
 * Restricts the height of the [Modifier] to be at most a fraction of the screen height.
 *
 * @param fraction The fraction of the screen height to use as the maximum height (0f..1f).
 * @return [Modifier] with a maximum height constraint.
 */
fun Modifier.fillHeightAtMost(fraction: Float): Modifier = composed {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp.value
    val maxHeightDp = (fraction * screenHeight).dp
    this.heightIn(max = maxHeightDp)
}

/**
 * Restricts the width of the [Modifier] to be at most a fraction of the screen width.
 *
 * @param fraction The fraction of the screen width to use as the maximum width (0f..1f).
 * @return [Modifier] with a maximum width constraint.
 */
fun Modifier.fillWidthAtMost(fraction: Float): Modifier = composed {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp.value
    val maxWidthDp = (fraction * screenWidth).dp
    this.widthIn(max = maxWidthDp)
}

/**
 * Restricts the size of the [Modifier] to be at most the specified fractions of
 * screen width and height.
 *
 * @param widthFraction The fraction of the screen width to use as the maximum width (0f..1f).
 * @param heightFraction The fraction of the screen height to use as the maximum height (0f..1f).
 * @return [Modifier] with maximum size constraints.
 */
fun Modifier.fillSizeAtMost(widthFraction: Float, heightFraction: Float): Modifier = composed {
    val config = LocalConfiguration.current
    val maxHeightDp = (heightFraction * config.screenHeightDp).dp
    val maxWidthDp = (widthFraction * config.screenWidthDp).dp
    this.sizeIn(maxHeight = maxHeightDp, maxWidth = maxWidthDp)
}

/**
 * Restricts the size of the [Modifier] to be at most a fraction of the screen size
 * in both width and height.
 *
 * @param fraction The fraction of the screen width and height to use as the maximum size (0f..1f).
 * @return [Modifier] with maximum size constraints.
 */
fun Modifier.fillSizeAtMost(fraction: Float): Modifier = composed {
    val config = LocalConfiguration.current
    val maxHeightDp = (fraction * config.screenHeightDp).dp
    val maxWidthDp = (fraction * config.screenWidthDp).dp
    this.sizeIn(maxHeight = maxHeightDp, maxWidth = maxWidthDp)
}
