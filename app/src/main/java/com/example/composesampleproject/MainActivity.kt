package com.example.composesampleproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesampleproject.custom_widget.showButton
import com.example.composesampleproject.custom_widget.showImage
import com.example.composesampleproject.custom_widget.showText
import com.example.composesampleproject.ui.theme.ComposeSampleProjectTheme
import com.example.composesampleproject.util.ItemClickListener

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleProjectTheme {
                MyFun(this)
            }
        }
    }
}

@Composable
fun MyFun(context:Context){

    val count= remember {
        mutableStateOf(0)
    }

    val itemClickListener=object :ItemClickListener{
        override fun onItemClick(num: Int) {
            if(num==0){
                count.value++
                //Toast.makeText(context,"Button pressed",Toast.LENGTH_SHORT).show()

            }else{
                count.value--
                //Toast.makeText(context,"Image Clicked",Toast.LENGTH_SHORT).show()

            }
        }

    }
    Surface(color = Color.Cyan) {
        ShowText(context ,"Print this value",itemClickListener,count.value)

    }
}

@Composable
fun ShowText(context: Context?,name: String, itemClickListener: ItemClickListener?,count: Int) {
    //Text(text = "$name", modifier = Modifier.padding(20.dp), color = Purple200)
    Row() {
        Column(modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp)) {
            Text(text = "Abc")
            Text(text = "ABC")
        }
        Column() {
            Text(text = "Pqr")
            Text(text = "PQR")
        }
        Text(text = "Xyz")

        Column(verticalArrangement = Arrangement.Center
            ,modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()) {
            showButton(itemClickListener)
            showText(count)
            showImage(itemClickListener)
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Bottom,
    modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 20.dp)
        .fillMaxHeight()
        .fillMaxWidth()) {
        Button(onClick = {
            context?.startActivity(Intent(context,SecondActivity::class.java))
        }) {
            Text(text = "Launch new activity")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleProjectTheme {
        ShowText(null,"yessssssss",null,0)
    }
}