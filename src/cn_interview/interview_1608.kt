package cn_interview

fun numberToWords(num: Int): String {
    fun StringBuilder.space(s: String) = append(s).append(' ')
    if (num == 0) {
        return "Zero"
    }
    val single = arrayOf(
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    )
    val tens = arrayOf(
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    )
    val hundreds = "Hundred"
    val thousands = arrayOf(
        "", "Thousand", "Million", "Billion"
    )
    var temp = num
    var i = 0
    val segments = ArrayList<String>()
    while (temp != 0) {
        val remainder = temp % 1000
        temp /= 1000
        val segment = buildString {
            val h = remainder / 100
            if (h != 0) {
                space(single[h])
                space(hundreds)
            }
            val t = remainder % 100
            if (t >= 20) {
                space(tens[t / 10])
                val s = t % 10
                if (s != 0)
                    space(single[s])
            } else if (t != 0) {
                space(single[t])
            }
            if (remainder != 0 && thousands[i].isNotEmpty())
                space(thousands[i])
            if (isNotEmpty())
                setLength(length - 1)
        }
        i++
        if (segment.isNotEmpty()) {
            segments.add(segment)
        }
    }
    return segments.asReversed().joinToString(" ")
}