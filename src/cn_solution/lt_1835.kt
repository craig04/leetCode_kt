package cn_solution

fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
    return arr1.reduce(Int::xor) and arr2.reduce(Int::xor)
}