package cn_solution

fun subStrHash(s: String, power: Int, modulo: Int, k: Int, hashValue: Int): String {
    val target = hashValue.toLong()
    val len = s.length
    var idx = 0
    var hash = 0L
    var time = 1L
    val temp = modulo.toLong() * modulo
    for (i in s.indices.reversed()) {
        hash = (s[i] - 'a' + 1 + hash * power) % modulo
        if (i > len - k) {
            time = (time * power) % modulo
        } else {
            if (hash == target)
                idx = i
            hash = (hash + temp - time * (s[i + k - 1] - 'a' + 1)) % modulo
        }
    }
    return s.substring(idx, idx + k)
}