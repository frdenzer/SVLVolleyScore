sealed class GameEvent {
    data class WonGame(val finalScore: ScoreEntry) : GameEvent()
}