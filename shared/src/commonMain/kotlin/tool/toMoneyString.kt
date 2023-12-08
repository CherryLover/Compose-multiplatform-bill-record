package tool

/**
 * @description 金额转换为字符串，带¥符号, 保留两位小数
 */
fun Double.toMoneyString() = "¥$this"