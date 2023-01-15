package cn_solution

fun minNumberOfHours(initialEnergy: Int, initialExperience: Int, energy: IntArray, experience: IntArray): Int {
    var result = 0
    var eng = initialEnergy
    var exp = initialExperience
    for (i in energy.indices) {
        var temp = maxOf(eng, energy[i] + 1)
        result += temp - eng
        eng = temp - energy[i]
        temp = maxOf(exp, experience[i] + 1)
        result += temp - exp
        exp = temp + experience[i]
    }
    return result
}