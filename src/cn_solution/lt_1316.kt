package cn_solution

fun distinctEchoSubstrings(text: String): Int {
    val modulo = 1000000007L
    val ensure = modulo * modulo
    var result = 0
    val hash = LongArray(text.length)
    val cycle = HashSet<Long>()
    for (len in 1..text.length / 2) {
        cycle.clear()
        var temp = 0L
        var substract = 1L
        for (i in text.indices) {
            temp = (text[i] - 'a' + 1 + temp * 31) % modulo
            if (i < len - 1)
                substract = substract * 31L % modulo
            else {
                if (i >= len && hash[i - len] == temp)
                    cycle.add(temp)
                hash[i] = temp
                temp = (temp + ensure - substract * (text[i - len + 1] - 'a' + 1)) % modulo
            }
        }
        result += cycle.size
    }
    return result
}