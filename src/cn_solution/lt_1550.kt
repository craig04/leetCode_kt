package cn_solution

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var cnt = 0
    return arr.any {
        if (it % 2 == 0)
            cnt = 0
        else
            cnt++
        cnt == 3
    }
}