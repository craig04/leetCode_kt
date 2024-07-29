package cn_solution

fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val map1 = s1.split(' ').groupingBy { it }.eachCount()
    val map2 = s2.split(' ').groupingBy { it }.eachCount()
    val ans = HashMap<String, Int>()
    map1.filterTo(ans) { it.value == 1 && it.key !in map2 }
    map2.filterTo(ans) { it.value == 1 && it.key !in map1 }
    return ans.map { it.key }.toTypedArray()
}