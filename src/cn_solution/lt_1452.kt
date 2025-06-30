package cn_solution

fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
    val map = HashMap<String, Int>()
    fun String.number() = map.computeIfAbsent(this) { map.size }
    val sets = Array(favoriteCompanies.size) { i ->
        favoriteCompanies[i].mapTo(HashSet()) { it.number() }
    }
    return sets.indices.filter { i ->
        sets.indices.none { j -> i != j && sets[j].containsAll(sets[i]) }
    }
}