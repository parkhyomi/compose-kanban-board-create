package woowacourse.kanban.board.domain.model

fun calculateCompletionPercent(doneCount: Int, totalCount: Int): Int {
    if (totalCount == 0) return 0

    val safeDoneCount = doneCount.coerceIn(0, totalCount)
    val progress = (safeDoneCount * 100) / totalCount
    return progress
}