package cn_solution

private fun minLights(lights: IntArray): Int {
    val n = lights.size
    val d = IntArray(n + 3)
    for (i in lights.indices) {
        val light = lights[i]
        if (light == 0)
            continue
        d[maxOf(0, i - light)]++
        d[minOf(n, i + light + 1)]--
    }
    var ans = 0
    var sum = 0
    for (i in 0 until n) {
        sum += d[i]
        if (sum == 0) {
            ans++
            sum++
            d[i + 3]--
        }
    }
    return ans
}