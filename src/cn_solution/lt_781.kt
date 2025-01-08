package cn_solution

fun numRabbits(answers: IntArray): Int {
    val map = HashMap<Int, Int>()
    return answers.sumOf {
        val count = map[it] ?: 0
        map[it] = count + 1
        if (count % (it + 1) == 0) it + 1 else 0
    }
}