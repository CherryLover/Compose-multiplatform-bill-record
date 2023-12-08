package view.tool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import view.lineHeight
import view.surfaceBgColor

fun Modifier.splitLine(height: Dp = lineHeight, color: Color = surfaceBgColor) = this.then(
  Modifier
    .fillMaxWidth()
    .height(height)
    .background(color = color)
)