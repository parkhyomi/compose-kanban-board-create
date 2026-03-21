package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import woowacourse.kanban.board.domain.model.Status
import woowacourse.kanban.board.ui.create.KanbanCreateDialog
import woowacourse.kanban.board.ui.preview.KanbanPreview

@Composable
fun KanbanBoard() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        BoardInfoHeader(
            totalCount = 10 , /** totalCount 넣어야함 **/
            doneCount = 5, /** doneCount 넣어야함 **/
            onTaskCreate = {
                showDialog = true
            },
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 16.dp),
        )
        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Status.entries.forEach { status ->
                BoardTaskBox(
                    boardTaskStatus = status,
                    boardTaskCount = 10, /** status 별 count 값 넣어야함 **/
                    headerColor = statusBackgroundColor(status),
                    borderColor = statusBorderColor(status),
                    mainColor = statusMainColor(status),
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
    if (showDialog) {
        KanbanCreateDialog(
            onDismissRequest = { showDialog = false },
        )
    }
}

private fun statusBackgroundColor(status: Status): Color {
    return when (status) {
        Status.TODO -> Color(0xFF155DFC)
        Status.IN_PROGRESS -> Color(0xFFE17100)
        Status.DONE -> Color(0xff00A63E)
    }
}

private fun statusMainColor(status: Status): Color {
    return when (status) {
        Status.TODO -> Color(0xffEFF6FF)
        Status.IN_PROGRESS -> Color(0xffFFFBEB)
        Status.DONE -> Color(0xFfF0FDF4)
    }
}

private fun statusBorderColor(status: Status): Color {
    return when (status) {
        Status.TODO -> Color(0xffBEDBFF)
        Status.IN_PROGRESS -> Color(0xffFEE685)
        Status.DONE -> Color(0xFFB9F8CF)
    }
}

@KanbanPreview
@Composable
private fun KanbanBoardPreview() {
    KanbanBoard()
}

