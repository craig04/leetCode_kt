package cn_solution

fun getWinner(arr: IntArray, k: Int): Int {
    var win = arr[0]
    var cnt = 0
    for (i in 1 until arr.size) {
        if (win < arr[i]) {
            win = arr[i]
            cnt = 1
        } else
            ++cnt
        if (cnt == k)
            break
    }
    return win
}