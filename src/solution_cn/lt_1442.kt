package solution_cn

fun countTriplets(arr: IntArray): Int {

    class Data(var sum: Int = 0, var count: Int = 0)

    val map = hashMapOf(0 to Data(0, 1))
    var temp = 0
    return arr.indices.sumBy {
        temp = temp xor arr[it]
        val data = map.getOrPut(temp) { Data(0, 0) }
        data.count++
        data.sum += it + 1
        data.count * it - data.sum + 1
    }
}