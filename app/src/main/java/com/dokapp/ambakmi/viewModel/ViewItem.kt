package com.dokapp.ambakmi.viewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokapp.ambakmi.R
import com.dokapp.ambakmi.models.Item


val favoriteItems = arrayListOf<Item>()
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ViewItem() {
    //test

    val item:Item = Item("A67002","Консультація Терапевта")
    var isFavoriteState by remember { mutableStateOf(item.isFavorite) }



        val paddingModifier = Modifier.padding(10.dp)
        Card(
            modifier = paddingModifier
        ) {
            Column() {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = item.cod,
                        color = Color.Blue,
                        modifier = Modifier.fillMaxWidth(0.6f).padding(10.dp))
                    Image( modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            changeFavorite(item)
                            isFavoriteState = item.isFavorite
                                   },
                        alignment = Alignment.Center,
                        painter =  if (isFavoriteState)
                            painterResource(id = R.drawable.favorite) 
                        else painterResource(id = R.drawable.not_favorite),
                        contentDescription = "img",
                    )
                }

                Text(text = item.name,
                    color = Color.Black,
                    modifier = paddingModifier)


        }
    }
    

}

fun changeFavorite(item: Item) {

    item.isFavorite = !item.isFavorite

     if (item.isFavorite == true)
     favoriteItems.add(item)
     else favoriteItems.remove(item)
}
