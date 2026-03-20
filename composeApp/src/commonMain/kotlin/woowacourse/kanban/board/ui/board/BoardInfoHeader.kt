package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.preview.KanbanPreview
import woowacourse.kanban.board.ui.theme.Blue

@Composable
fun BoardInfoHeader(
    onTaskCreate: () -> Unit
) {
    Row {
        Column {
            Text(
                text = "Compose Desktop 칸반 보드",
            )
            Text(
                text = "완료율 ~~~",
            )
        }

        BoardInfoHeader_ContentButton(onTaskCreate)
    }
}

@Composable
fun BoardInfoHeader_ContentButton(
    onTaskCreate: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onTaskCreate,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue)
    ){
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "새 태스크 생성",
            modifier = modifier.size(20.dp)
        )
        Text(
            text = "새 태스크 생성",
            color = Color.White
        )
    }
}
@KanbanPreview
@Composable
private fun BoardInfoHeaderPreview() {
    BoardInfoHeader(onTaskCreate = { })
}

@KanbanPreview
@Composable
private fun BoardInfoHeader_ContentButtonPreview() {
    BoardInfoHeader_ContentButton(onTaskCreate = { })
}