package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.create.KanbanCreateDialog
import woowacourse.kanban.board.ui.preview.KanbanPreview

@Composable
fun KanbanBoard() {
    var showDialog by remember { mutableStateOf(false) }

    Column() {
        BoardInfoHeader(
            totalCount = 10,
            doneCount = 5,
            onTaskCreate = {
                showDialog = true
            },
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                .background(Color.White),
        )
        HorizontalDivider()
    }
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
