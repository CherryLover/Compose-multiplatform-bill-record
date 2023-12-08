import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bean.DayRecord
import bean.Record
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import view.DayRecordView
import view.PageView
import view.ToolBarView

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val temps = listOf(
        DayRecord(
            "10.10", dateSemantic = "今天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.09", dateSemantic = "昨天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.10", dateSemantic = "今天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.09", dateSemantic = "昨天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.10", dateSemantic = "今天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.09", dateSemantic = "昨天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        ),
        DayRecord(
            "10.08", dateSemantic = "前天", list = listOf(
                Record(1, 100.0, "12:00", expression = "88+12", activityName = "桶装水", bookName = "Jiang"),
                Record(1, 100.0, "13:01", description = "感冒药", activityName = "药品", bookName = "Bo"),
                Record(1, 100.0, "13:01", activityName = "工资", bookName = "Bo", dealType = 20),
            )
        )
    )
    val days = mutableStateListOf<DayRecord>()
    repeat(3000) {
        days.addAll(temps)
    }

//    MaterialTheme {
//        var greetingText by remember { mutableStateOf("Hello, World!") }
//        var showImage by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Hello, ${getPlatformName()}"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }
//    }
    PageView {
        ToolBarView("RecordList") {

        }
        LazyColumn {
            items(days.size) {
                DayRecordView(it, days[it])
            }
        }
    }
}

expect fun getPlatformName(): String