package woowacourse.kanban.board.ui.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.Status


@Composable
fun rememberKanbanBoardState(
    initialStatusCards: Map<Status, List<Card>> = Status.entries.associateWith { emptyList() },
): KanbanBoardState = remember(initialStatusCards) { KanbanBoardState(initialStatusCards) }

class KanbanBoardState(
    initialStatusCards: Map<Status, List<Card>>,
) {

    var todoCards by mutableStateOf(initialStatusCards[Status.TODO].orEmpty())
        private set

    var inProgressCards by mutableStateOf(initialStatusCards[Status.IN_PROGRESS].orEmpty())
        private set

    var doneCards by mutableStateOf(initialStatusCards[Status.DONE].orEmpty())
        private set

    fun statusCards(status: Status): List<Card> =
        when (status) {
            Status.TODO -> todoCards
            Status.IN_PROGRESS -> inProgressCards
            Status.DONE -> doneCards
        }

    fun addCard(status: Status, card: Card) {
        when (status) {
            Status.TODO -> todoCards = todoCards + card
            Status.IN_PROGRESS -> inProgressCards = inProgressCards + card
            Status.DONE -> doneCards = doneCards + card
        }
    }

    fun totalAddCard(): Int {
        return todoCards.size + inProgressCards.size + doneCards.size
    }

    fun doneAddCard(): Int = doneCards.size
}
