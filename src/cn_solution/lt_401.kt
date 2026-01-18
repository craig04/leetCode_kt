package cn_solution

fun readBinaryWatch(turnedOn: Int): List<String> {
    val ans = ArrayList<String>()
    for (h in 0 until 12)
        for (m in 0 until 60)
            if (h.countOneBits() + m.countOneBits() == turnedOn)
                ans.add(String.format("%d:%02d", h, m))
    return ans
}