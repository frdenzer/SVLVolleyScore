import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

object GameViewModel //: ViewModel() {
{
    private val _events = MutableSharedFlow<GameEvent>()
    val events = _events.asSharedFlow()

    private val _logbook = MutableStateFlow<List<ScoreEntry>>(emptyList())
    val hasLogEntries: Boolean
        get() = _logbook.value.isNotEmpty()

    fun onSetWon(finalScore: ScoreEntry) {
//        viewModelScope.launch {
//            _events.emit(GameEvent.WonGame(finalScore))
//        }
    }

    fun updateSetLogbook(entry: ScoreEntry) {
//        viewModelScope.launch {
            val updatedLog = _logbook.value.toMutableList().apply {
                add(entry)
            }
            _logbook.value = updatedLog
//        }
    }

    fun resetSetLog() {
        _logbook.value = emptyList()
        TeamMagenta.reset()
        TeamCyan.reset()
    }

    fun logbookOfSets(
        abbreviate: Boolean = false,
        addItem: (Int, ScoreEntry) -> Unit,
    ) = looper(abbreviate).forEach { (index, entry) ->
        addItem(index, entry)
    }

    private fun looper(
        abbreviate: Boolean = false,
    ): List<Pair<Int, ScoreEntry>> {
        val maxIndex = _logbook.value.size - 1

        // In abbreviated log, only show the last two entries. This is not the default.
        // get only [maxIndex, maxIndex - 1], i.e. the highest two entries
        val earlyEnd = if (abbreviate) maxIndex - 2 else 0
        val safeEnd = maxOf(earlyEnd, 0) // Prevents negative index

        return (maxIndex downTo safeEnd).map { index ->
            index + 1 to _logbook.value[index]
        }
    }
}

