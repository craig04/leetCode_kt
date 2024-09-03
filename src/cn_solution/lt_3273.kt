package cn_solution

fun minDamage(power: Int, damage: IntArray, health: IntArray): Long {
    val n = health.size
    val enemy = Array(n) { intArrayOf(damage[it], (health[it] + power - 1) / power) }
    enemy.sortWith { l, r -> (l[0] * 1L * r[1]).compareTo(l[1] * 1L * r[0]) }
    var total = 0L
    return enemy.sumOf {
        total += it[0]
        total * it[1]
    }
}