package cn_lcr

fun evalRPN(tokens: Array<String>): Int {
    val nums = IntArray(tokens.size)
    var idx = 0
    for (t in tokens) {
        if (t.length != 1 || t.first().isDigit()) {
            nums[idx++] = t.toInt()
        } else {
            val r = nums[--idx]
            val l = nums[--idx]
            nums[idx++] = when (t) {
                "+" -> l + r
                "-" -> l - r
                "*" -> l * r
                else -> l / r
            }

        }
    }
    return nums.first()
}