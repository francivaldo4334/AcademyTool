import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize 
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.widthIn

@Composable
@Preview
fun ClientsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
                modifier =
                        Modifier.fillMaxHeight()
                                .widthIn(max = LocalDimensionsSizeScreen.maxWidth)
                                .padding(horizontal = 16.dp)
        ) { ClientsHeader() }
    }
}
