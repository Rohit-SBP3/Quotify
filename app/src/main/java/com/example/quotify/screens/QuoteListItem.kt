package com.example.quotify.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.quotify.model.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth(1f).clickable { onClick(quote) },
        border = BorderStroke(2.dp, Color(0xFF3F51B5))
    ) {
        Row (
            modifier = Modifier.padding(16.dp)
        ){
            Image(
                imageVector = Icons.Filled.FormatQuote, contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color(0xFF3F51B5))
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp),
                    color = Color.Black
                )
                Box(modifier = Modifier.background(Color(0xFF3F51B5)).
                    fillMaxWidth(.4f)
                    .height(1.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }

    }
}