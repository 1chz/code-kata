package io.github.shirohoo.stringcalculator

data class Expression(val expr: String) {
    init {
        require(expr.matches(pattern)) {
            "not the correct expression"
        }
    }

    companion object {
        private val pattern: Regex = "^\\d+(?: ?[+\\-*/] ?\\d+)*$".toRegex()
    }
}