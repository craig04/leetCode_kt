package cn_solution

fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val groups = groupSizes.indices.groupBy { groupSizes[it] }
    val result = ArrayList<List<Int>>()
    groups.forEach { (k, v) ->
        var group = ArrayList<Int>()
        var i = 0
        while (i != v.size) {
            group.add(v[i])
            if (++i % k == 0) {
                result.add(group)
                group = ArrayList()
            }
        }
    }
    return result
}