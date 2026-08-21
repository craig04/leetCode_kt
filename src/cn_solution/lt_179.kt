package cn_solution

fun largestNumber(nums: IntArray): String {
    val strs = Array(nums.size) { nums[it].toString().toCharArray() }
    strs.sortWith { s1, s2 ->
        val len1 = s1.size
        val len2 = s2.size
        for (i in 0 until len1 + len2) {
            val c1 = if (i >= len1) s2[i - len1] else s1[i]
            val c2 = if (i >= len2) s1[i - len2] else s2[i]
            val res = c2.compareTo(c1)
            if (res != 0)
                return@sortWith res
        }
        0
    }
    val builder = StringBuilder()
    for (s in strs) {
        builder.append(s)
    }
    return if (builder.all { it == '0' }) "0" else builder.toString()
}

