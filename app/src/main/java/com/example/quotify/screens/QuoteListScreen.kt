package com.example.quotify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotify.model.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column{
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF3F51B5))){
                    append("Q")
                }
                append("uotify ")
            },
            color = Color.Black,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(6.dp,6.dp).fillMaxWidth(1f),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        QuoteList(data = data, onClick)
    }
}
