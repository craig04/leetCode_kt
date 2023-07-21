package cn_solution

fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
    return (0..total step cost1).sumOf { (total - it) / cost2 + 1L }
}