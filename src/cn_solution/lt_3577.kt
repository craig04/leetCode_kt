package cn_solution

fun countPermutations(complexity: IntArray): Int {
    return (1 until complexity.size).fold(1) { ans, i ->
        if (complexity[i] <= complexity[0])
            return 0
        (1L * ans * i).mod(1000000007)
    }
}