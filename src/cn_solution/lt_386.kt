package cn_solution

fun lexicalOrder(n: Int): List<Int> {
    val ans = ArrayList<Int>()
    var num = 1
    do {
        ans.add(num)
        if (num * 10 <= n) {
            num *= 10
        } else {
            while (num % 10 == 9 || num + 1 > n)
                num /= 10
            num++
        }
    } while (num != 1)
    return ans
}