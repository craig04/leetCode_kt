package cn_solution

class Solution_273 {

    companion object {
        val ones = arrayOf(
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        )
        val tens = arrayOf(
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety",
        )
        val thousands = arrayOf("Billion", "Million", "Thousand", "")
        val threshold = arrayOf(1000000000, 1000000, 1000, 1)
    }

    operator fun StringBuilder.plusAssign(s: String) {
        append(' ').append(s)
    }

    fun numberToWords(num: Int): String {
        if (num == 0)
            return "Zero"
        val sb = StringBuilder()
        for (i in thousands.indices) {
            var x = num / threshold[i] % 1000
            if (x == 0)
                continue
            if (x >= 100) {
                sb += ones[x / 100]
                sb += "Hundred"
                x %= 100
            }
            if (x >= 20) {
                sb += tens[x / 10]
                x %= 10
            }
            if (x != 0)
                sb += ones[x]
            sb += thousands[i]
        }
        return sb.trim().toString()
    }
}