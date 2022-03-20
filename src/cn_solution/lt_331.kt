package cn_solution

fun isValidSerialization(preorder: String): Boolean {
    var slots = 1
    preorder.split(',').forEach {
        if (--slots == -1)
            return false
        if (it != "#")
            slots += 2
    }
    return slots == 0
}