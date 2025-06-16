package com.saberoueslati.pandora.ui.utils.modifier

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

/**
 * Ensures the [Modifier] has a minimum height that is at least a fraction of the screen height.
 *
 * @param fraction The fraction of the screen height to use as the minimum height (0f..1f).
 * @return [Modifier] with a minimum height constraint.
 */
fun Modifier.fillHeightAtLeast(fraction: Float): Modifier = composed {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val minHeightDp = (fraction * screenHeight.value).dp
    this.heightIn(min = minHeightDp)
}

/**
 * Ensures the [Modifier] has a minimum width that is at least a fraction of the screen width.
 *
 * @param fraction The fraction of the screen width to use as the minimum width (0f..1f).
 * @return [Modifier] with a minimum width constraint.
 */
fun Modifier.fillWidthAtLeast(fraction: Float): Modifier = composed {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val minWidthDp = (fraction * screenWidth.value).dp
    this.widthIn(min = minWidthDp)
}

/**
 * Ensures the [Modifier] has minimum width and height at least fractions of the screen width and height.
 *
 * @param widthFraction The fraction of the screen width to use as the minimum width (0f..1f).
 * @param heightFraction The fraction of the screen height to use as the minimum height (0f..1f).
 * @return [Modifier] with minimum size constraints.
 */
fun Modifier.fillSizeAtLeast(widthFraction: Float, heightFraction: Float): Modifier = composed {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val minWidthDp = (widthFraction * screenWidth.value).dp
    val minHeightDp = (heightFraction * screenHeight.value).dp
    this.sizeIn(minWidth = minWidthDp, minHeight = minHeightDp)
}

/**
 * Ensures the [Modifier] has minimum width and height at least a fraction of the screen size.
 *
 * @param fraction The fraction of the screen width and height to use as the minimum size (0f..1f).
 * @return [Modifier] with minimum size constraints.
 */
fun Modifier.fillSizeAtLeast(fraction: Float): Modifier = composed {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val minWidthDp = (fraction * screenWidth.value).dp
    val minHeightDp = (fraction * screenHeight.value).dp
    this.sizeIn(minWidth = minWidthDp, minHeight = minHeightDp)
}