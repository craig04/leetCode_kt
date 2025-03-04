package cn_solution

fun brokenCalc(startValue: Int, target: Int): Int {
    if (startValue >= target)
        return startValue - target
    return 1 + brokenCalc(startValue, if (target and 1 == 1) target + 1 else target / 2)
}