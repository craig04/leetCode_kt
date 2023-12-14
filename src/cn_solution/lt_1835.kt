package cn_solution

fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
    return arr1.reduce { a, b -> a xor b } and arr2.reduce { a, b -> a xor b }
}