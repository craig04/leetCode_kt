package cn_solution

fun numRescueBoats(people: IntArray, limit: Int): Int {
    var i = 0
    var j = people.lastIndex
    var ans = 0
    people.sort()
    while (i < j) {
        if (people[i] + people[j] <= limit)
            i++
        j--
        ans++
    }
    if (i == j)
        ans++
    return ans
}