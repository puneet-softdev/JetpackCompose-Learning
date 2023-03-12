package com.codingwithpuneet.jetpackcomposelearningapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Greeting("Puneet")
            //DefaultPreview()
//            TextComposableWithClick("Puneet"){
//                Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
//            }
            LazyColumnComposableWithClick{
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingWithSmallCustomization(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    TextComposableWithModifier()
//    TextComposableWithClick("Puneet"){
        // to do
// }
//    ButtonComposable()
//    OutlineButtonComposable()

    // ColumnLayoutComposable()
    // RowLayoutComposable()


//    ImageComposable()
//    ImageComposableWithBox()
//    ColumnLayoutWithScroll()
    // LazyColumnComposable()
    LazyColumnComposableWithClick {
        // TODO
    }
}

// Customize Text
@Composable
fun TextComposableWithModifier(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Blue)
            .padding(10.dp)
            .fillMaxWidth(1.0f),
        style = MaterialTheme.typography.button
    )
}

// Customize Text with Click Listener
@Composable
fun TextComposableWithClick(name: String, selectedItem:(String)-> (Unit)) {
    Text(
        text = "Hello $name!",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Blue)
            .padding(10.dp)
            .fillMaxWidth(1.0f)
            .clickable { selectedItem("Hello") }
    )
}

// Button Composable
@Composable
fun ButtonComposable(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.large,
    ) {
        Text(
            text = "Subscribe CodingWithPuneet",
            color = Color.White
        )
    }
}

// Outline Button Composable
@Composable
fun OutlineButtonComposable(){
    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Subscribe CodingWithPuneet",
            color = Color.White
        )
    }
}

// Image Composable
@Composable
fun ImageComposable(){
    Image(
        painter = painterResource(id = R.drawable.clean),
        contentDescription = "Hello",
        Modifier
            .width(150.dp)
            .height(150.dp)
    )
}

// Image Composable with Box
@Composable
fun ImageComposableWithBox(){
    Box {
        Image(
            painter = painterResource(id = R.drawable.clean),
            contentDescription = "Smiling",
        )
        Text(
            text = "CodingWithPuneet",
            color = Color.Blue,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp, 0.dp, 0.dp, 10.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(0.dp, 0.dp, 10.dp, 0.dp)
        ) {
            Text(
                text = "Subscribe CodingWithPuneet",
                color = Color.White
            )
        }
    }
}

// Column Layout
@Composable
fun ColumnLayoutComposable(){
    Column(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Greeting("Puneet")
    }
}

// Row Layout
@Composable
fun RowLayoutComposable(){
    Row(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        GreetingWithSmallCustomization("Puneet")
    }
}

// Column Layout with Scroll
@Composable
fun ColumnLayoutWithScroll(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    )
    {
        for(i in 1..100){
            Text(
                text = "CodingWithPuneet Watched video:- $i",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 4.dp)
        }
    }
}

@Composable
fun LazyColumnComposable(){
    LazyColumn {
        items(100){
            Text(
                text = "CodingWithPuneet Watching video:- $it",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp),
                color = Color.Blue
            )
            Divider(color = Color.Blue, thickness = 2.dp)
        }
    }
}

@Composable
fun LazyColumnComposableWithClick(selectedItem: (String) -> Unit){
    LazyColumn {
        items(100){
            Text(
                text = "CodingWithPuneet Watching video:- $it",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp)
                    .clickable { selectedItem("$it Watched") },
                color = Color.Blue
            )
            Divider(color = Color.Blue, thickness = 2.dp)
        }
    }
}









