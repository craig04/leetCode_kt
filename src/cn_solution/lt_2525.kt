package cn_solution

fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
    val cat = arrayOf("Neither", "Heavy", "Bulky", "Both")
    var bit = if (mass >= 100) 1 else 0
    if (maxOf(length, width, height) >= 10000 || 1L * length * width * height >= 1000000000)
        bit += 2
    return cat[bit]
}