package cn_solution

fun largestString(nums: IntArray): Array<String> {
    val len = IntArray(26) { 1 shl it }
    return Array(nums.size) {
        val ans = StringBuilder()
        var x = nums[it]
        for (i in len.indices.reversed()) {
            val cnt = x / len[i]
            repeat(cnt) { ans.append('a' + i) }
            x -= cnt * len[i]
        }
        ans.toString()
    }
}