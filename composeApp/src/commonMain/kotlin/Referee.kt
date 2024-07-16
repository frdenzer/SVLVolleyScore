object Referee {
    val sendWinEvent: (ScoreEntry) -> Unit = GameViewModel::onSetWon

    fun score(who: Team): () -> Unit = {
        who.teamScore += 1
        checkWinConditions()
    }

    fun decrementScore(who: Team): () -> Unit = {
        who.teamScore -= 1
        checkWinConditions()
    }

    private fun checkWinConditions() {
        val scoreLeadA = TeamMagenta.teamScore - (TeamCyan.teamScore)
        if (TeamMagenta.teamScore >= 25 && scoreLeadA > 1) {
            closeSetSavingScore()()
            return
        }

        // inverse. happens on decrementing points.
        val scoreLeadB = TeamCyan.teamScore - TeamMagenta.teamScore
        if (TeamCyan.teamScore >= 25 && scoreLeadB > 1) closeSetSavingScore(TeamCyan)()
    }

    internal fun closeSetSavingScore(
        who: Team = TeamMagenta,

        ): () -> Unit = {
        // no matter who won, we need to store the results.
        sendWinEvent(
            ScoreEntry(
                TeamMagenta.colorId, TeamMagenta.teamScore, TeamCyan.colorId, TeamCyan.teamScore
            )
        )

        if (TeamMagenta == who) {
            TeamMagenta.teamScore = 0
            TeamMagenta.teamSetsWon += 1
            TeamCyan.teamScore = 0
        } else {
            TeamCyan.teamScore = 0
            TeamCyan.teamSetsWon += 1
            TeamMagenta.teamScore = 0
        }
    }
}