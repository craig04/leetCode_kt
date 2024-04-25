package cn_solution

fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
    return (mainTank + minOf((mainTank - 1) / 4, additionalTank)) * 10
}