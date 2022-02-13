package cn_solution

fun readBinaryWatch(turnedOn: Int): List<String> {
    val result = ArrayList<String>()
    for (h in 0 until 12) {
        for (m in 0 until 60) {
            if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                result.add(String.format("%d:%02d", h, m))
            }
        }
    }
    return result
}