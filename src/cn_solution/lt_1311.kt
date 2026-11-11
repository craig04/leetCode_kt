package cn_solution

fun watchedVideosByFriends(
    watchedVideos: List<List<String>>,
    friends: Array<IntArray>,
    id: Int,
    level: Int
): List<String> {
    val vis = BooleanArray(friends.size)
    val queue = ArrayDeque<Int>()
    vis[id] = true
    queue.add(id)
    repeat(level) {
        repeat(queue.size) {
            val x = queue.removeFirst()
            for (y in friends[x]) {
                if (!vis[y]) {
                    vis[y] = true
                    queue.addLast(y)
                }
            }
        }
    }
    val cnt = HashMap<String, Int>()
    for (friend in queue)
        for (video in watchedVideos[friend])
            cnt.merge(video, 1, Int::plus)
    return cnt.entries
        .sortedWith(compareBy({ it.value }, { it.key }))
        .map { it.key }
}