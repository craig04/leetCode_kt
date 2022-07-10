package cn_solution

fun checkIfExist(arr: IntArray): Boolean {
    val map = arr.indices.associateBy { arr[it] }
    return arr.indices.any {
        if (arr[it] == 0) map[0] != it else arr[it] * 2 in map
    }
}