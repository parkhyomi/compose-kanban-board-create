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

    private var cardsByStatus by mutableStateOf(
        Status.entries.associateWith { initialStatusCards[it].orEmpty() }
    )

    fun statusCards(status: Status): List<Card> =
        cardsByStatus[status].orEmpty()

    fun addCard(status: Status, card: Card) {
        val newCards = cardsByStatus.toMutableMap()
        newCards[status] = newCards[status].orEmpty() + card
        cardsByStatus = newCards
    }

    fun totalAddCard(): Int {
        return cardsByStatus.values.sumOf { it.size }
    }

    fun doneAddCard(): Int = cardsByStatus[Status.DONE].orEmpty().size
}
