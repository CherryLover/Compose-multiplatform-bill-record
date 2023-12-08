package view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import bean.DayRecord
import bean.Record
import tool.toMoneyString
import view.tool.splitLine

/**
 * @description
 * @author: Created jiangjiwei in 2023/12/8 15:08
 */
@Composable
fun DayRecordView(idx: Int, dayRecord: DayRecord) {
  val rememberSum by remember(dayRecord.list) { mutableStateOf(dayRecord.list.sumOf { it.money }) }
  Column(
    Modifier
      .fillMaxWidth()
      .padding(horizontal = marginMiddle)
      .background(cardBgColor, roundCornerShape)
  ) {
    Row(
      Modifier.height(36.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      val dayText by remember(dayRecord) { mutableStateOf("${dayRecord.date} ${dayRecord.dateSemantic}") }
      val summaryText by remember(rememberSum) { mutableStateOf("总计：$rememberSum") }
      Spacer(modifier = Modifier.width(marginMax))
      Text(text = dayText, fontWeight = FontWeight.Medium)
      Spacer(modifier = Modifier.weight(1f))
      Text(text = summaryText, fontWeight = FontWeight.Medium)
      Spacer(modifier = Modifier.width(marginMax))
    }
    Spacer(modifier = Modifier.splitLine())
    val size = dayRecord.list.size
    dayRecord.list.forEachIndexed { index, record ->
      RecordView(record)
      if (index != size - 1) {
        Spacer(modifier = Modifier.splitLine())
      }
    }
  }
  if (idx != 0) {
    Spacer(modifier = Modifier.height(marginMax))
  }
}

@Composable
fun RecordView(record: Record) {
  Row(
    Modifier
      .fillMaxWidth()
      .height(actionHeight), verticalAlignment = Alignment.CenterVertically
  ) {
    Spacer(modifier = Modifier.width(marginMax))
    val dealColor by remember(record) { mutableStateOf(if (record.isOut()) billOutColor else billInColor) }
    Box(
      Modifier
        .size(8.dp)
        .background(dealColor, CircleShape)
    )
    Spacer(modifier = Modifier.width(marginMax))

    val activityName by remember(record) { mutableStateOf(record.activityName) }
    val description by remember(record) { mutableStateOf(record.description) }

    val sign by remember(record) { mutableStateOf(if (record.isOut()) "-" else "+") }
    val money by remember(record) { mutableStateOf(sign + " " + record.money.toMoneyString()) }
    val expression by remember(record) { mutableStateOf(record.expression) }


    Column {
      Text(text = activityName, color = textColorPrimary, fontSize = textSizePrimary)
      if (description.isNotEmpty()) {
        Text(text = description, color = textColorSecondary, fontSize = textSizeSecondary)
      }
    }
    Spacer(modifier = Modifier.weight(1f))
    Column(
      verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.End
    ) {

      Text(text = money, color = dealColor, fontSize = textSizePrimary)
      if (expression.isNotEmpty()) {
        Text(text = expression, color = textColorSecondary, fontSize = textSizeSecondary)
      }
    }
    Spacer(modifier = Modifier.width(marginMax))
  }
}