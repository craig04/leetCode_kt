package cn_solution

fun largestTimeFromDigits(arr: IntArray): String {
    var ans = -1
    for (i in 0 until 4)
        for (j in 0 until 4)
            if (j != i)
                for (k in 0 until 4)
                    if (k != i && k != j) {
                        val l = 6 - i - j - k
                        val h = arr[i] * 10 + arr[j]
                        val m = arr[k] * 10 + arr[l]
                        if (h < 24 && m < 60)
                            ans = maxOf(ans, h * 60 + m)
                    }
    return if (ans == -1) "" else String.format("%02d:%02d", ans / 60, ans % 60)
}