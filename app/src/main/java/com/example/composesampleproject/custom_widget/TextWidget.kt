package com.example.composesampleproject.custom_widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun showText(count:Int){
    Text(text = "Count is $count",modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp), textAlign = TextAlign.Center)
}