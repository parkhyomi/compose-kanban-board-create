package woowacourse.kanban.board.domain.model

data class User(val name: String, val profileImg: String? = null) {
    init {
        require(name.isNotBlank()) {
            "이름은 공백일 수 없습니다."
        }
    }

    companion object {
        val managersList = listOf(
            User("디노"),
            User("제임스"),
        )
    }
}
