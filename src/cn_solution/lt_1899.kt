package cn_solution

fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
    val max = IntArray(3)
    loop@ for (triplet in triplets) {
        for (i in triplet.indices)
            if (triplet[i] > target[i])
                continue@loop
        for (i in triplet.indices)
            max[i] = maxOf(max[i], triplet[i])
    }
    return max.asList() == target.asList()
}