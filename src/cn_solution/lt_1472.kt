package cn_solution

class BrowserHistory(homepage: String) {

    private val urls = arrayListOf(homepage)
    private var curr = 0
    private var last = 0

    fun visit(url: String) {
        last = ++curr
        if (curr == urls.size)
            urls.add(url)
        else
            urls[curr] = url
    }

    fun back(steps: Int): String {
        curr = maxOf(0, curr - steps)
        return urls[curr]
    }

    fun forward(steps: Int): String {
        curr = minOf(last, curr + steps)
        return urls[curr]
    }
}