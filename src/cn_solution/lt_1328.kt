package cn_solution

fun breakPalindrome(palindrome: String): String {
    val n = palindrome.length
    if (n == 1)
        return ""
    val c = palindrome.toCharArray()
    for (i in 0 until n / 2)
        if (c[i] != 'a') {
            c[i] = 'a'
            return String(c)
        }
    c[n - 1] = 'b'
    return String(c)
}