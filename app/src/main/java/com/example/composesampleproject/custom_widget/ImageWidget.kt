package com.example.composesampleproject.custom_widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composesampleproject.R
import com.example.composesampleproject.util.ItemClickListener

@Composable
fun showImage(itemClickListener: ItemClickListener?){
    Image(modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp).clickable { itemClickListener?.onItemClick(1) }
        ,painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Icon")
}
