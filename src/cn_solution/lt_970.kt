package cn_solution

fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
    fun generate(n: Int): List<Int> {
        if (n == 1)
            return listOf(1)
        val list = ArrayList<Int>()
        var product = 1
        while (product <= bound) {
            list.add(product)
            product *= n
        }
        return list
    }

    val list1 = generate(x)
    val list2 = generate(y)
    val result = HashSet<Int>()
    for (i in list1) {
        for (j in list2) {
            if (i + j > bound)
                break
            result.add(i + j)
        }
    }
    return result.toList()
}