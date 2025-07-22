package cn_solution

fun doesValidArrayExist(derived: IntArray): Boolean {
    return derived.reduce(Int::xor) == 0
}