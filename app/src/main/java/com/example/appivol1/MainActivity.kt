package com.example.appivol1

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appivol1.ui.theme.Appivol1Theme


// Main Activity class
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Appi()
        }
    }
}


@Composable
fun Appi() {
    // State for toggling the dark theme
    val isDarkTheme = remember { mutableStateOf(false) }
    val colors = if (isDarkTheme.value) darkColorScheme() else lightColorScheme()

    // Applies the custom theme, changes based on the isDarkTheme state
    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography
    )  {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // LazyColumn is a vertically scrolling list that only composes elements currently in view
            LazyColumn(
                modifier = Modifier.padding(20.dp)
            ) {
                item {
                    // Image composable to display a picture
                    Image(
                        painter = painterResource(id = R.drawable.pepe),
                        contentDescription = "pepe",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(shape = MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
                //spacer for padding
                item { Spacer(modifier = Modifier.height(50.dp)) }

                // Loop to create multiple Text composables
                items(20) { index ->
                    Text(
                        text = "Pepe $index",
                        fontSize = (20 + index).sp, //font size
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                // Button to toggle the dark theme
                item {
                    Button(onClick = { isDarkTheme.value = !isDarkTheme.value }) {
                        Text(text = "Dark Theme")
                    }
                }
            }
        }
    }
}


// Preview function for the Appi composable
@Preview(showBackground = true)
@Composable
fun AppiPreview() {
    Appi()
}