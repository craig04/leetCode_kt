package cn_solution

fun minPenalty(period: Int, lights: IntArray, arrivalTime: IntArray): Int {
    val light = lights.max()
    return arrivalTime.maxOf {
        val t = it % period
        if (t < light) 0 else period - t
    }
}