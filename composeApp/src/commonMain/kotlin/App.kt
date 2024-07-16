import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

object TeamMagenta : Team(Color(0xFFE040FB))
object TeamCyan : Team(Color(0xFF40C4FF))


@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TeamMagenta()
            TeamCyan()
        }
    }
}

import androidx.compose.ui.graphics.Color

data class ScoreEntry(val teamAColor: Color, val teamAScore: Int, val teamBColor: Color, val teamBScore: Int)