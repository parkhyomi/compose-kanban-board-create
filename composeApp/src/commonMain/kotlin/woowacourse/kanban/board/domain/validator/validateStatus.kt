package woowacourse.kanban.board.domain.validator

import woowacourse.kanban.board.domain.model.Status

private const val TODO = "TO DO"
private const val IN_PROGRESS = "In Progress"
private const val DONE = "Done"

fun validateStatus( status: Status) : String {
    return when(status) {
        Status.TODO -> TODO
        Status.IN_PROGRESS -> IN_PROGRESS
        Status.DONE -> DONE
    }
}
