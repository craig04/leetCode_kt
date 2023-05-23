package cn_solution

fun sampleStats(count: IntArray): DoubleArray {
    var min = -1
    var max = -1
    var sum = 0L
    var samples = 0
    var most = 0
    for (i in count.indices) {
        if (count[i] == 0)
            continue
        if (min == -1)
            min = i
        max = i
        sum += i.toLong() * count[i]
        samples += count[i]
        if (count[i] > count[most]) {
            most = i
        }
    }
    val right = samples / 2 + 1
    var cnt = 0
    var last = 0
    var median = 0
    for (i in count.indices) {
        if (count[i] == 0) continue
        cnt += count[i]
        if (cnt >= right) {
            median += i + if (samples and 1 == 0 && cnt - count[i] == right - 1) last else i
            break
        }
        last = i
    }
    return doubleArrayOf(
        min.toDouble(), max.toDouble(), sum.toDouble() / samples, median / 2.0, most.toDouble()
    )
}