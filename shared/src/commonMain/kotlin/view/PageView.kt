package view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @description
 * @author: Created jiangjiwei in 2023/12/7 21:38
 */
@Composable
fun PageView(content: @Composable () -> Unit) {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
    content()
  }
}

@Composable
fun ToolBarView(
  title: String,
  textColor: Color = Color.Black,
  textSize: TextUnit = 18.sp,
  menuContent: (@Composable () -> Unit)? = null,
  onBackInvoke: () -> Unit
) {
  Row(
    Modifier.fillMaxWidth().height(48.dp)
  ) {
    Icon(Icons.Rounded.ArrowBack, "Back", modifier = Modifier.clickable {
      onBackInvoke()
    })
    Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
      Text(title, color = textColor, fontSize = textSize)
    }
    if (menuContent!= null) {
      menuContent()
    }
  }
}