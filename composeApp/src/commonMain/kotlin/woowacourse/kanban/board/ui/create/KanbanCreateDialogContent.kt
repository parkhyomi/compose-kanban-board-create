package woowacourse.kanban.board.ui.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.Status
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.ui.create.maincontent.ContentArea
import woowacourse.kanban.board.ui.create.maincontent.ManagerSelector
import woowacourse.kanban.board.ui.create.maincontent.StatusSelector
import woowacourse.kanban.board.ui.create.maincontent.TagArea
import woowacourse.kanban.board.ui.create.maincontent.TitleArea
import woowacourse.kanban.board.ui.preview.KanbanPreview

@Composable
fun KanbanCreateDialogContent(
    onDismiss: () -> Unit,
    onCreateConfirm: (Status, Card) -> Unit,
    modifier: Modifier = Modifier,
    state: KanbanCreateDialogContentState = rememberKanbanCreateDialogContentState(),
    managers: List<User> = User.managersList,
) {
    Column(
        modifier = modifier
            .background(Color.White),
    ) {
        KanbanCreateHeader(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 28.dp),
            onDismiss = onDismiss,
        )

        HorizontalDivider()

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {

            TitleArea(
                value = state.title,
                onTitleChange = state::onTitleChange,
                isError = state.isTitleError,
            )

            ContentArea(
                value = state.content,
                onContentChange = state::onContentChange,
            )

            TagArea(
                value = state.tag,
                onTagChange = state::onTagChange,
                errorMessage = state.tagErrorMessage,
                isError = state.isTagError,
            )

            StatusSelector(
                selectedStatus = state.status,
                onStatusChange = state::onStatusChange,
            )

            ManagerSelector(
                managers = managers,
                selectedUser = state.selectedUser,
                onUserChange = state::onUserChange,
            )
        }
        HorizontalDivider()
        KanbanCreateFooter(
            onClickCancel = onDismiss,
            onClickConfirm = {
                val (status, card) = state.buildCreateResult()
                onCreateConfirm(status, card)
            },
            enabled = state.isConfirmEnabled,
        )
    }
}

@Composable
@KanbanPreview
fun KanbanCreateDialogContentPreview() {
    KanbanCreateDialogContent(
        onDismiss = {},
        onCreateConfirm = { _, _ -> },
    )
}
