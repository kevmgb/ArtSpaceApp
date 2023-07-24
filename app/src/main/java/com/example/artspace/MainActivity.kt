package com.example.artspace

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var screenNum by remember { mutableStateOf(1) }

    val imageResource = when (screenNum) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val artistName = when (screenNum) {
        1 -> "Mathew Mason (2020)"
        2 -> "Jack Reacher (2019)"
        3 -> "Ashley Young (2002)"
        else -> "Evelyne Trezia (1899)"
    }

    val paintingTitle = when (screenNum) {
        1 -> "A lemon Tree"
        2 -> "A lemon ready for squeezing"
        3 -> "Drinking the juice"
        else -> "Ready to start again"
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(imageResource),
            contentDescription = "Lemon Glass",
            modifier = Modifier
                .weight(8f)
                .align(Alignment.CenterHorizontally)
        )

        ArtworkInformation(paintingTitle, artistName, modifier = Modifier.background(Color.Blue))
        Spacer(modifier = Modifier.height(25.dp))
        ButtonsRow(
            onValueChange = {screenNum = it},
            screenNum = screenNum,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun ArtworkInformation(artTitle: String, artistName: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = artTitle,
            color = Color.DarkGray
        )
        Text(
            text = artistName,
            color = Color.DarkGray
        )
    }
}

@Composable
fun ButtonsRow(
    screenNum: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val contextForToast = LocalContext.current.applicationContext
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(bottom = 10.dp)
    ){
        Button(
            onClick = {

                if (screenNum <= 1) {
                    onValueChange(1)
                }else {
                    onValueChange(screenNum - 1)
                }
                      },
            modifier = Modifier
                .height(40.dp)
                .width(150.dp)
                .padding(end = 10.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = {
                if (screenNum >= 4) {
                    onValueChange(1)
                }else {
                    onValueChange(screenNum + 1)
                }
            },
            modifier = Modifier
                .height(40.dp)
                .width(150.dp)
                .padding(start = 10.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}