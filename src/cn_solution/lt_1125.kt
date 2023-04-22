package cn_solution

fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
    val skills = req_skills.indices.associate { req_skills[it] to 1.shl(it) }
    val peoples = Array(people.size) { people[it].fold(0) { acc, s -> acc or skills[s]!! } }
    val total = 1.shl(skills.size)
    val dp = Array(total) { intArrayOf(people.size + 1, 0, 0) }
    dp[0][0] = 0
    peoples.forEachIndexed { i, p ->
        for (j in 0 until total) {
            val curInfo = dp[j]
            val nextSkill = j or p
            val nextInfo = dp[nextSkill]
            if (curInfo[0] + 1 < nextInfo[0]) {
                nextInfo[0] = curInfo[0] + 1
                nextInfo[1] = j
                nextInfo[2] = i
            }
        }
    }
    val result = ArrayList<Int>()
    var temp = dp[total - 1]
    do {
        result.add(temp[2])
        temp = dp[temp[1]]
    } while (temp[0] != 0)
    return result.toIntArray()
}