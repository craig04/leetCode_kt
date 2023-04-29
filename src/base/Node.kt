package base

class Node(@JvmField var `val`: Int) {
    @JvmField
    var children: List<Node?> = listOf()
}