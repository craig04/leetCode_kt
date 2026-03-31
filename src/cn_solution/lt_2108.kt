package cn_solution

fun firstPalindrome(words: Array<String>): String {
    loop@ for (word in words) {
        var i = 0
        var j = word.lastIndex
        while (i < j)
            if (word[i++] != word[j--])
                continue@loop
        return word
    }
    return ""
}