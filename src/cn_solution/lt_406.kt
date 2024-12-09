package cn_solution

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    val ans = ArrayList<IntArray>()
    people.sortWith(compareBy({ -it[0] }, { it[1] }))
    for (p in people)
        ans.add(p[1], p)
    return ans.toTypedArray()
}