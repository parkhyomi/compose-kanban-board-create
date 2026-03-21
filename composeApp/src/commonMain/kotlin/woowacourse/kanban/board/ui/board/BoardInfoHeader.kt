package woowacourse.kanban.board.ui.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.preview.KanbanPreview
import woowacourse.kanban.board.ui.theme.Blue

@Composable
fun BoardInfoHeader(
    totalCount: Int,
    doneCount: Int,
    onTaskCreate: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "Compose Desktop 칸반 보드",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "완료율: "+taskComplete(doneCount, totalCount)+" (${doneCount}/${totalCount})",
                )
            }

            BoardInfoHeader_ContentButton(onTaskCreate)
        }
        BoardInfoHeader_Progress()
    }
}

fun taskComplete(doneCount: Int, totalCount: Int): String {
    if (totalCount == 0) return "0%"

    val progress = (doneCount * 100) / totalCount
    return "$progress%"
}

@Composable
fun BoardInfoHeader_Progress(
    modifier: Modifier = Modifier,
) {
    LinearProgressIndicator(modifier = modifier.fillMaxWidth())
}

@Composable
fun BoardInfoHeader_ContentButton(
    onTaskCreate: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onTaskCreate,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "새 태스크 생성",
            modifier = Modifier.size(20.dp),
        )
        Text(
            text = "새 태스크 생성",
            color = Color.White,
        )
    }
}

@KanbanPreview
@Composable
private fun BoardInfoHeaderPreview() {
    BoardInfoHeader(
        totalCount = 10,
        doneCount = 5,
        onTaskCreate = { }
    )
}

@Preview
@Composable
private fun BoardInfoHeader_ProgressPreview() {
    BoardInfoHeader_Progress()
}

@Preview
@Composable
private fun BoardInfoHeader_ContentButtonPreview() {
    BoardInfoHeader_ContentButton(onTaskCreate = { })
}
