package com.example.composesampleproject

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composesampleproject.custom_widget.showButton
import com.example.composesampleproject.custom_widget.showImage
import com.example.composesampleproject.util.ItemClickListener

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showText(this)
        }
    }
}

@Composable
fun showText(context: Activity) {
    val count = remember {
        mutableStateOf(10000)
    }
    val itemClickListener = object : ItemClickListener {
        override fun onItemClick(num: Int) {
            if (num == 0) {
                count.value = count.value * 10
            } else {
                count.value = count.value / 10
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Second Activity") },
                backgroundColor = Color.Magenta
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { context.finish() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            showButton(itemClickListener)
            com.example.composesampleproject.custom_widget.showText(count.value)
            showImage(itemClickListener)
        }

    }
}