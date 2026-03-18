package woowacourse.kanban.board.domain.validator

private const val TAG_FORMAT_MESSAGE = "태그 형식이 올바르지 않습니다."
private const val TAG_LIMIT_MESSAGE = "태그는 5자 이내로 5개까지만 등록할 수 있습니다"

fun validateTagInput(tag: String): String? {
    val formatted = tag.split(",").map { it.trim() }
    if (formatted.any { it.isBlank() }) return TAG_FORMAT_MESSAGE
    if (formatted.any { it.length > 5 } || formatted.size > 5) return TAG_LIMIT_MESSAGE
    return null
}
