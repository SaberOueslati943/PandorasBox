package com.saberoueslati.pandorasbox.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.saberoueslati.pandora.ui.designsystem.Spacing

@Composable
@Preview(showBackground = true, name = "Spacing Preview")
fun SpacingPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        SpacingItem("none (0.dp)", Spacing.none)
        SpacingItem("xxs (4.dp)", Spacing.xxs)
        SpacingItem("xs (8.dp)", Spacing.xs)
        SpacingItem("sm (12.dp)", Spacing.sm)
        SpacingItem("md (16.dp)", Spacing.md)
        SpacingItem("lg (24.dp)", Spacing.lg)
        SpacingItem("xl (32.dp)", Spacing.xl)
    }
}

@Composable
private fun SpacingItem(label: String, height: Dp) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label)
        Box(
            modifier = Modifier
                .height(height)
                .fillMaxWidth()
                .background(Color.LightGray)
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
    }
}