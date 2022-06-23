package io.github.shirohoo.ghostleg.domain

data class Name(val name: String) {
    init {
        require(namePattern.matches(name)) {
            "The 'name' must be a string consisting of English, Korean, and Numeric characters of 1 to 5 characters."
        }
    }

    companion object {
        val namePattern = Regex("^[a-zA-Z0-9가-힣]{1,5}$")
    }
}
