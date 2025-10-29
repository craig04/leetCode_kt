package cn_solution

class Bank(val balance: LongArray) {

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (account2 - 1 !in balance.indices)
            return false
        return change(account1, -money) && change(account2, money)
    }

    fun deposit(account: Int, money: Long): Boolean {
        return change(account, money)
    }

    fun withdraw(account: Int, money: Long): Boolean {
        return change(account, -money)
    }

    fun change(account: Int, money: Long): Boolean {
        if (account - 1 !in balance.indices || balance[account - 1] + money < 0)
            return false
        balance[account - 1] += money
        return true
    }
}