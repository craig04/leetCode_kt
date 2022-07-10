package cn_solution

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = arrayListOf(-1)
    for (a in asteroids) {
        if (a > 0) {
            stack.add(a)
            continue
        }
        while (stack.last() > 0 && stack.last() < -a)
            stack.removeAt(stack.lastIndex)
        if (stack.last() < 0)
            stack.add(a)
        else if (stack.last() == -a)
            stack.removeAt(stack.lastIndex)
    }
    return IntArray(stack.size - 1) { stack[it + 1] }
}