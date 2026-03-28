package woowacourse.kanban.board.ui.create

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.Status
import woowacourse.kanban.board.domain.model.Tag
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.domain.validator.validateTagInput

@Composable
fun rememberKanbanCreateDialogContentState(
    initialSelectedUser: User = User.managersList.first(),
): KanbanCreateDialogContentState = remember { KanbanCreateDialogContentState(initialSelectedUser) }

@Stable
class KanbanCreateDialogContentState(
    initialSelectedUser: User,
) {
    var title by mutableStateOf("")
        private set

    var isTitleError by mutableStateOf(false)
        private set

    var content by mutableStateOf("")
        private set

    var tag by mutableStateOf("")
        private set

    var isTagError by mutableStateOf(false)
        private set

    var tagErrorMessage: String? by mutableStateOf(null)
        private set

    var status by mutableStateOf(Status.TODO)
        private set

    var selectedUser by mutableStateOf(initialSelectedUser)
        private set

    val isConfirmEnabled: Boolean
        get() = !isTitleError && title.isNotBlank() && !isTagError

    fun onTitleChange(newTitle: String) {
        title = newTitle
        isTitleError = newTitle.isBlank()
    }

    fun onContentChange(newContent: String) {
        content = newContent
    }

    fun onTagChange(newTag: String) {
        tag = newTag
        tagErrorMessage = validateTagInput(newTag)
        isTagError = tagErrorMessage != null
    }

    fun onStatusChange(newStatus: Status) {
        status = newStatus
    }

    fun onUserChange(newUser: User) {
        selectedUser = newUser
    }

    fun buildCreateResult(): Pair<Status, Card> {
        val tags = parseTagInput(tag)
        val card = Card(
            title = title,
            content = content.takeIf { it.isNotBlank() },
            tags = tags,
            user = selectedUser,
        )
        return status to card
    }
}

private fun parseTagInput(tagInput: String): List<Tag> {
    if (tagInput.isBlank()) return emptyList()

    return tagInput
        .split(",")
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map(::Tag)
}
