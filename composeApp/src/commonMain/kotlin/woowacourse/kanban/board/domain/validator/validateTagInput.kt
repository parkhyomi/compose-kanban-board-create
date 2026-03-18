package woowacourse.kanban.board.domain.validator

fun validateTagInput(tag: String): String? {
    val formatted = tag.split(",").map { it.trim() }
    if (formatted.any { it.isBlank() }) return "태그 형식이 올바르지 않습니다."
    if (formatted.any { it.length > 5 } || formatted.size > 5) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다"
    return null
}
