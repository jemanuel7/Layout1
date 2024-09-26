package com.juanmendez.claselayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*


import com.juanmendez.claselayout.ui.theme.ClaseLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaseLayout1()

        }
    }
}
@Composable
fun ClaseLayout1(){

    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        EjemploColumn()
        EjemploRow()
        EjemploBox()
       //Saludo(nombre = "Juan")
       // ColorCambiante()
       // Contador()
    }

}

@Composable
fun EjemploColumn() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Primer Elemento")
        Text("Segundo Elemento")
        Text("Tercer Elemento")
    }
}

@Composable
fun EjemploRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Izquierda")
        Text("Centro")
        Text("Derecha")
    }
}

@Composable
fun EjemploBox() {
    Box {
        Box(modifier = Modifier.size(100.dp).background(Color.Blue))
        Text(
            "Primer plano",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Composable
fun Saludo (nombre: String){
    Text(text = "Hola $nombre")
}

/*Recomposable*/
@Composable
fun ColorCambiante() {
    var colorActual by remember { mutableStateOf(Color.Red) }
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(colorActual)
        )
        Button(onClick = {
            colorActual = when (colorActual) {
                Color.Red -> Color.Green
                Color.Green -> Color.Blue
                else -> Color.Red
            }
        }) {
            Text("Cambiar a Azul")
        }
    }
}

/*Estado*/
@Composable
fun Contador (){
    var cuenta by remember{mutableStateOf(0) }
    Button (onClick = {cuenta++}){
        Text ("La cuenta es $cuenta")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClaseLayoutTheme {
        ClaseLayout1()

    }
}