package woowacourse.kanban.board.domain.model.board

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.Status
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.ui.board.KanbanBoardState
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class KanbanBoardTest {

    @Test
    fun `태스크 생성 이벤트가 전달되면 선택한 상태 컬럼에 카드가 추가된다`() = runTest {
        val initial = mapOf(
            Status.TODO to listOf(Card(title = "todo-1", user = User("디노"))),
            Status.IN_PROGRESS to listOf(
                Card(title = "inprogress-1", user = User("제임스")),
                Card(title = "inprogress-2", user = User("로미")),
            ),
            Status.DONE to emptyList(),
        )

        val boardState = KanbanBoardState(initial)

        boardState.addCard(
            Status.DONE,
            Card("done-1", user = User("로미"))
        )

        assertEquals(1, boardState.statusCards(Status.TODO).size)
        assertEquals(2, boardState.statusCards(Status.IN_PROGRESS).size)
        assertEquals(1, boardState.statusCards(Status.DONE).size)
        assertEquals(4, boardState.totalAddCard())
        assertEquals(1, boardState.doneAddCard())
    }
}
