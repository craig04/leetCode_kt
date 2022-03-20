package cn_solution

fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val map = list1.indices.associateByTo(HashMap()) { list1[it] }
    var sum = Int.MAX_VALUE
    val result = ArrayList<String>()
    for (i in list2.indices) {
        val temp = i + (map[list2[i]] ?: continue)
        if (temp < sum) {
            sum = temp
            result.clear()
            result.add(list2[i])
        } else if (temp == sum) {
            result.add(list2[i])
        }
    }
    return result.toTypedArray()
}