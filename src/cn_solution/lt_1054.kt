package cn_solution

fun rearrangeBarcodes(barcodes: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    for (code in barcodes)
        map[code] = (map[code] ?: 0) + 1
    val n = barcodes.size
    val half = n / 2
    var even = 0
    var odd = 1
    val result = IntArray(n)
    map.forEach {
        var count = it.value
        while (count in 1..half && odd < n) {
            result[odd] = it.key
            odd += 2
            count--
        }
        while (count > 0) {
            result[even] = it.key
            even += 2
            count--
        }
    }
    return result
}