package cn_solution

fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    return targetCapacity <= jug1Capacity + jug2Capacity && targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0
}