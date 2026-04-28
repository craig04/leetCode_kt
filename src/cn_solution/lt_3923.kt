package cn_solution

fun minGenerations(points: Array<IntArray>, target: IntArray): Int {
    fun hash(x: Int, y: Int, z: Int) = x.shl(6) + y.shl(3) + z
    val dest = hash(target[0], target[1], target[2])
    var curr = points.mapTo(HashSet()) { (x, y, z) -> hash(x, y, z) }
    var ans = 0
    while (true) {
        if (dest in curr)
            return ans
        val next = HashSet<Int>()
        for (p in curr) {
            val x = p.shr(6)
            val y = p.shr(3).and(7)
            val z = p.and(7)
            for (q in curr) {
                val a = q.shr(6)
                val b = q.shr(3).and(7)
                val c = q.and(7)
                next += hash((x + a) / 2, (y + b) / 2, (z + c) / 2)
            }
        }
        if (curr.size == next.size)
            break
        curr = next
        ans++
    }
    return -1
}