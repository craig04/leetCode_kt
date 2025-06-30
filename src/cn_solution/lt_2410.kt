package cn_solution

fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
    players.sort()
    trainers.sort()
    var ans = 0
    var i = 0
    val n = trainers.size
    for (player in players) {
        while (i != n && trainers[i] < player)
            i++
        if (i++ == n)
            break
        ans++
    }
    return ans
}