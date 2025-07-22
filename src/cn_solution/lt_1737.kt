package cn_solution

fun minCharacters(a: String, b: String): Int {
    fun count(x: String, y: String): Int {
        return ('b'..'z').minOf { c ->
            x.count { it >= c } + y.count { it < c }
        }
    }
    return minOf(
        count(a, b),
        count(b, a),
        ('a'..'z').minOf { c -> a.count { it != c } + b.count { it != c } })
}