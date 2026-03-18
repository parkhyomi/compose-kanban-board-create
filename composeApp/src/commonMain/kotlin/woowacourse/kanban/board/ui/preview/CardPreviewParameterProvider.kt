package woowacourse.kanban.board.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.Tag
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.ui.card.KanbanCard

private class CardPreviewParameterProvider : PreviewParameterProvider<Card> {
    override val values = sequenceOf(
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            tags = listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임")),
            user = User(name = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄"),
        ),
    )
}

@Composable
@Preview
private fun KanbanCardPreview(@PreviewParameter(CardPreviewParameterProvider::class) card: Card) {
    KanbanCard(card)
}
