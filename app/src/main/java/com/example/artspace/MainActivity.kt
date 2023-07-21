package com.example.artspace

import android.os.Bundle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.lemon_drink),
            contentDescription = "Lemon Glass",
            modifier = Modifier
                .weight(8f)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Artwork Title",
            modifier = Modifier
//                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Artwork Artist (Year)",
            modifier = Modifier
//                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        ButtonsRow(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun ArtworkInformation(modifier: Modifier = Modifier) {
        Text(text = "Artwork Title")
        Text(text = "Artwork Artist (Year)")
}

@Composable
fun ButtonsRow(
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(bottom = 10.dp)
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .padding(end = 10.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
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