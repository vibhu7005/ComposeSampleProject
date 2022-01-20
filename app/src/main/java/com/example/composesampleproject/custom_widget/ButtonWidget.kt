package com.example.composesampleproject.custom_widget

import android.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesampleproject.util.ItemClickListener

@Composable
fun showButton(itemClickListener: ItemClickListener?){
    Button(colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.Magenta)
        ,onClick = { itemClickListener?.onItemClick(0) }
        ,modifier = Modifier.border(5.dp,androidx.compose.ui.graphics.Color.Green, shape = RoundedCornerShape(10.dp))
    ) {
        Text(text = "Click here",color = androidx.compose.ui.graphics.Color.Blue)
    }
}