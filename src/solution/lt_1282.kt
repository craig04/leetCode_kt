package solution

fun groupThePeople(groupSizes: IntArray): List<List<Int>> {

    val result = ArrayList<List<Int>>()
    val groups = HashMap<Int, ArrayList<Int>>()
    groupSizes.forEachIndexed { index, i ->
        if (groups.getOrPut(i) { arrayListOf() }.apply { add(index) }.size == i) {
            groups.remove(i)?.let { result.add(it) }
        }
    }
    return result
}