package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun MyApp(){


    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    val scope = rememberCoroutineScope()

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            TopAppBar(
                title = { Text("Backdrop") },
                navigationIcon = {
                    if (scaffoldState.isConcealed) {
                        IconButton(
                            onClick = {
                                scope.launch { scaffoldState.reveal() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = {
                                scope.launch { scaffoldState.conceal() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )
        },
        backLayerContent = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Gray
            ){
                Text("Background")
                // Add Your Content
            }
        },
        frontLayerContent = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Yellow
            ){
                Text("Foreground")
                // Add Your Content
            }
        }

    )


}

