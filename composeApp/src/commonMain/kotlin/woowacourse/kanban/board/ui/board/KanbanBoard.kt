package woowacourse.kanban.board.ui.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.ui.create.KanbanCreateDialog
import woowacourse.kanban.board.ui.preview.KanbanPreview

@Composable
fun KanbanBoard() {
    var showDialog by remember { mutableStateOf(false) }

    BoardInfoHeader(
        onTaskCreate = {
            showDialog = true
        },
    )
    if (showDialog) {
        KanbanCreateDialog(
            onDismissRequest = { showDialog = false }
        )
    }
}

@KanbanPreview
@Composable
private fun KanbanBoardPreview() {
    KanbanBoard()
}