package woowacourse.kanban.board.domain.validator

import woowacourse.kanban.board.domain.model.Card.Companion.MAX_TAG_SIZE
import woowacourse.kanban.board.domain.model.Tag.Companion.MAX_TAG_LENGTH

private const val TAG_FORMAT_MESSAGE = "태그 형식이 올바르지 않습니다."
private const val TAG_LIMIT_MESSAGE = "태그는 5자 이내로 5개까지만 등록할 수 있습니다"

fun validateTagInput(tag: String): String? {

    val tags = formatTag(tag)

    return when {
        blankTag(tags) -> TAG_FORMAT_MESSAGE
        limitTag(tags) -> TAG_LIMIT_MESSAGE
        else -> null
    }

}

private fun formatTag(tag: String): List<String> {
    return tag.split(",").map { it.trim() }
}

private fun blankTag(tags: List<String>): Boolean {
    return tags.any { it.isBlank() }
}

private fun limitTag(tags: List<String>): Boolean {
    return tags.size > MAX_TAG_SIZE || tags.any { it.length > MAX_TAG_LENGTH }
}