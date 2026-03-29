package woowacourse.kanban.board.ui.component

import androidx.compose.ui.graphics.Color
import woowacourse.kanban.board.domain.model.Status

data class BoardTaskBoxColors(
    val headerColor: Color,
    val mainColor: Color,
    val borderColor: Color,
)

object BoardTaskBoxDefaults {
    fun colors(status: Status): BoardTaskBoxColors = when (status) {
        Status.TODO -> BoardTaskBoxColors(
            headerColor = Color(0xFF155DFC),
            mainColor = Color(0xFFEFF6FF),
            borderColor = Color(0xFFBEDBFF),
        )
        Status.IN_PROGRESS -> BoardTaskBoxColors(
            headerColor = Color(0xFFE17100),
            mainColor = Color(0xFFFFFBEB),
            borderColor = Color(0xFFFEE685),
        )
        Status.DONE -> BoardTaskBoxColors(
            headerColor = Color(0xFF00A63E),
            mainColor = Color(0xFFF0FDF4),
            borderColor = Color(0xFFB9F8CF),
        )
    }
}