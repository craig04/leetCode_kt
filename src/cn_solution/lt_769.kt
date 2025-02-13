package cn_solution

private fun maxChunksToSorted(arr: IntArray): Int {
    var diff = 0
    return arr.indices.count {
        diff += it - arr[it]
        diff == 0
    }
}