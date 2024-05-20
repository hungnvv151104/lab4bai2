package hungnvvph32403.fpt.lab4bai2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hungnvvph32403.fpt.lab4bai2.ui.theme.Lab4Bai2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val images = listOf(R.drawable.ava_1, R.drawable.ava_2,
                R.drawable.ava_3)
            Column {
                Icon(
                    painter = painterResource(id =
                    R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo"
                )
                HorizontalImageList(images)
                VerticalImageList(images)
            }
        }
    }
}

@Composable
fun HorizontalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier
        .horizontalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        start = if (index == 0) 0.dp else 8.dp,
                        end = 8.dp
                    )
            )
        }
    }
}

@Composable
fun VerticalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalImageList() {
    HorizontalImageList(listOf(R.drawable.ava_1, R.drawable.ava_2,
        R.drawable.ava_3))
}
@Preview(showBackground = true)
@Composable
fun PreviewVerticalImageList() {
    VerticalImageList(listOf(R.drawable.ava_1, R.drawable.ava_2,
        R.drawable.ava_3))
}

