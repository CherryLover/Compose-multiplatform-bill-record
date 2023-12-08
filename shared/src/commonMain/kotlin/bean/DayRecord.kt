package bean

data class DayRecord(
  /**
   * yyyy-MM-dd
   */
  val date: String, val list: List<Record>, val dateSemantic: String = ""
)

data class Record(
  val activityType: Int,
  val money: Double,
  /**
   * hh:mm:ss
   */
  val time: String,
  val description: String = "",
  val expression: String = "",
  var dealType: Int = 10,
  val activityName: String = "",
  val bookName: String = "",
) {
  fun isOut() = dealType == 10
}