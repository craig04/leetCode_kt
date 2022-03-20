package cn_solution

class Bank(private val balance: LongArray) {

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account1.invalid() || account2.invalid() || balance[account1.index()] < money) return false
        balance[account1.index()] -= money
        balance[account2.index()] += money
        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (account.invalid()) return false
        balance[account.index()] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (account.invalid() || balance[account.index()] < money) return false
        balance[account.index()] -= money
        return true
    }

    private fun Int.invalid() = this !in (1..balance.size)
    private fun Int.index() = this - 1
}