package cn_solution

fun prevPermOpt1(arr: IntArray): IntArray {
    val last = arr.lastIndex
    val pivot = (last downTo 1).firstOrNull {
        arr[it - 1] > arr[it]
    } ?: return arr
    val pos = (last downTo pivot).first {
        arr[it] < arr[pivot - 1] && (it == pivot || arr[it - 1] != arr[it])
    }
    val temp = arr[pos]
    arr[pos] = arr[pivot - 1]
    arr[pivot - 1] = temp
    return arr
}