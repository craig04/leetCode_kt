package cn_solution

fun kthCharacter(k: Int): Char {
    return 'a' + (k - 1).countOneBits() % 26
}