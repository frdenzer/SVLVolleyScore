import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
internal fun BigNumbers(modifier: Modifier) {
//    val context = LocalContext.current
//    val configuration = LocalConfiguration.current
//    val windowManager = getSystemService(context, WindowManager::class.java)
//    val rotation = windowManager?.defaultDisplay?.rotation
//    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
//    val isReverseLandscape = isLandscape && (rotation == Surface.ROTATION_270)

    val wide = Modifier.fillMaxWidth()
    BoxWithConstraints(modifier = modifier) {
        if (maxWidth > maxHeight) {
            Row(
                modifier = wide,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
//                if (!isReverseLandscape) {
//                    TeamScoreKolumn(
//                        TeamMagenta,
//                        modifier
//                            .background(TeamMagenta.colorId)
//                            .weight(1f)
//                    )
//                }
                TeamScoreKolumn(
                    TeamCyan,
                    modifier
                        .background(TeamCyan.colorId)
                        .weight(1f)
                )
//                if (isReverseLandscape) {
                    TeamScoreKolumn(
                        TeamMagenta,
                        modifier
                            .background(TeamMagenta.colorId)
                            .weight(1f)
                    )
//                }
            }
            return@BoxWithConstraints
        }
        Column(
            modifier = wide,
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TeamScoreKolumn(
                TeamMagenta,
                wide
                    .background(TeamMagenta.colorId)
                    .weight(1f)
            )
            TeamScoreKolumn(
                TeamCyan,
                wide
                    .background(TeamCyan.colorId)
                    .weight(1f)
            )
        }
    }
}
