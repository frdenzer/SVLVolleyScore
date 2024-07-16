import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun TeamScoreKolumn(
    team: Team, modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // This will center the Row vertically
    ) {

        val textColor = Color.White
        ScalingText(
            text = team.teamScore.toString(),
            color = textColor,
        )
        Row {
            Button(onClick = Referee.score(team)) {
                Text("+")
            }
//            HorizontalSpacing()
            Button(
                onClick = Referee.decrementScore(team),
                enabled = team.teamScore > 0,

                ) {
                Text("-")
            }
        }
//        VerticalSpacing()
        Text(
            text = "Sets: ${team.teamSetsWon}",
//            style = MaterialTheme.typography.headlineSmall.copy(color = textColor)
        )
        // useful for testing, do not ship in production: the following button stores any result
        Row {
            Button(enabled = team.teamScore > 0, onClick = Referee.closeSetSavingScore(team)) {
                Text("close set as win")
            }
        }
    }
}

@Composable
fun ScalingText(text: String, color: Color) {
//    val configuration = LocalConfiguration.current
//    val screenWidth = configuration.screenWidthDp.dp
//    val dynamicFontSize = (screenWidth / (text.length / 3 + 4.5f)).value.coerceAtLeast(12f).sp

    Text(
        text = text,
//        style = MaterialTheme.typography.displayLarge.copy(
//            color = color, fontSize = dynamicFontSize
//        )
    )
}
