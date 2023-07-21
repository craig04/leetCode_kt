package cn_offer

fun verifyPostorder(postorder: IntArray): Boolean {
    fun verify(left: Int, right: Int): Boolean {
        if (left >= right)
            return true
        val p = (left until right).firstOrNull {
            postorder[it] >= postorder[right]
        } ?: right
        return (p until right).all {
            postorder[it] > postorder[right]
        } && verify(left, p - 1) && verify(p, right - 1)
    }
    return verify(0, postorder.lastIndex)
}