package br.com.shaft.aluvery.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.shaft.aluvery.R
import br.com.shaft.aluvery.ui.theme.AluveryTheme
import br.com.shaft.aluvery.ui.theme.Purple40

class Challenge01Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Surface {
                    Challenge01Content(modifier = Modifier
                        .fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Challenge01Content(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        val boxWidth = 100.dp
        Box(Modifier
            .width(boxWidth)
            .height(200.dp)
            .background(brush = Brush.verticalGradient(
                colors = listOf(Color.Blue, Purple40)
            ))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(boxWidth)
                    .offset(x = (boxWidth / 2))
                    .clip(CircleShape)
                    .border(2.dp, brush = Brush.verticalGradient(colors = listOf(
                        Purple40,
                        Color.Blue
                    )), CircleShape)
                    .align(Alignment.CenterEnd)
            )
        }
        Spacer(modifier = Modifier.width(boxWidth/2))
        Text(
            text = LoremIpsum(50).values.first(),
            modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp),
            maxLines = 6,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Challenge01ContentPreview() {
    AluveryTheme {
        Challenge01Content()
    }
}