package com.example.composecourseyt


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.rubikpixels_regular, FontWeight.Bold),
            Font(R.font.tiltprism_regular,FontWeight.ExtraBold)
        )

        setContent {
                val painter = painterResource(id = R.drawable.kermit)
                val contentDescription = " Kermit is playing"
            ImageCard(
                painter = painter,
                contentDescription = contentDescription,
                title = contentDescription,
            )
            }

        }
    }

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier = Modifier
){
    val fontFamily = FontFamily(
        Font(R.font.rubikpixels_regular, FontWeight.Bold),
        Font(R.font.tiltprism_regular,FontWeight.ExtraBold)
    )
    val color = remember{mutableStateOf(Color.Yellow)}
    Box(modifier = modifier
        .fillMaxSize()
        .fillMaxWidth()
        .background(color = color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.Blue, fontSize = 50.sp)
                ) {
                    append("J")
                }
                append("etpack")
                withStyle(
                    style = SpanStyle(color = Color.Blue, fontSize = 50.sp)
                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.Blue,
            fontSize = 25.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = modifier.align(Alignment.TopCenter)
        )
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = 50.dp,
            backgroundColor = Color.DarkGray,
            modifier = modifier
                .padding(top = 75.dp)
                .align(Alignment.TopCenter)
        ) {
            Box(
                modifier = modifier
                    .fillMaxHeight(0.75f)
                    .fillMaxWidth(0.75f)
                    .background(color = Color.DarkGray)
            )

            {
                Box(modifier = modifier.padding(top = 50.dp)) {
                    Image(
                        painter = painter,
                        contentDescription = contentDescription,
                        contentScale = ContentScale.Crop
                    )
                }

                Box(
                    modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Blue
                                ), startY = 300f
                            )
                        )
                )
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, color = Color.White, fontSize = 30.sp)
                }

            }

        }


    }
}

@Composable
fun SnackBar(modifier:Modifier =Modifier){
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Box {
        Scaffold(scaffoldState = scaffoldState) {
            TextField(
                value = textFieldState, label = {
                    Text("Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true
            )
            Spacer(modifier = modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                }

            }) {
                Text("pls greet me")
            }

        }
    }

}









//Box(modifier = Modifier
//.fillMaxSize()
//.background(Color(0xFF0037FF))){
//    Text(
//        text = buildAnnotatedString {
//            withStyle(
//                style = SpanStyle(
//                    color = Color.Red,
//                    fontSize = 50.sp
//                )
//            ){
//                append("J")
//            }
//            append("etpack")
//            withStyle(
//                style = SpanStyle(
//                    color = Color.Red,
//                    fontSize = 50.sp
//                )
//            ){
//                append("C")
//            }
//            append("ompose")
//        },
//        color = Color.White,
//        fontSize = 30.sp,
//        fontFamily= fontFamily,
//        fontWeight = FontWeight.Bold,
//        fontStyle = FontStyle.Italic,
//        textAlign = TextAlign.Center,
//        textDecoration = TextDecoration.Underline
//    )
//}
//val painter= painterResource(id = R.drawable.kermit)
//val description = "Kermit playing"
//val title = "Kermit playing"
//ImageCard(painter = painter, contentDescription = description , title = title)



//@Composable
//fun ImageCard(
//    painter: Painter,
//    contentDescription: String,
//    title: String,
//    modifier: Modifier = Modifier
//){
//Card(
//    modifier = modifier.fillMaxWidth().padding(100.dp),
//    shape = RoundedCornerShape(15.dp),
//    elevation = 5.dp
//){
//    Box(modifier= modifier
//        .height(400.dp)
//    ){
//        Image(
//            painter= painter,
//            contentDescription = contentDescription,
//          contentScale = ContentScale.Crop
//        )
//        Box(modifier = modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    colors = listOf(
//                        Color.Transparent,
//                        Color.Black
//                    ),
//                startY = 700f
//                )
//            ))
//        Box(modifier = modifier
//            .fillMaxSize()
//            .padding(12.dp),
//        contentAlignment = Alignment.BottomStart){
//            Text(title, style = TextStyle(color = Color.White), fontSize = 30.sp)
//        }
//    }
//}
//}
