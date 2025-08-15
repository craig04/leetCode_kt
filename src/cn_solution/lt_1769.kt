package cn_solution

private fun minOperations(boxes: String): IntArray {
    var ops = 0
    var left = 0
    var right = 0
    for (i in boxes.indices)
        if (boxes[i] == '1') {
            right++
            ops += i
        }
    ops += right
    return IntArray(boxes.length) {
        ops += left - right
        if (boxes[it] == '1') {
            left++
            right--
        }
        ops
    }
}