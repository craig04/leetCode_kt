package cn_solution

fun stringHash(s: String, k: Int): String {
    return s.indices.step(k).joinToString("") {
        ('a' + (it until it + k).sumOf { i -> s[i] - 'a' } % 26).toString()
    }
}