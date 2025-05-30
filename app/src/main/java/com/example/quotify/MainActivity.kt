package com.example.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotify.screens.QuoteDetailScreen
import com.example.quotify.screens.QuoteList
import com.example.quotify.screens.QuoteListScreen
import com.example.quotify.ui.theme.QuotifyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            QuoteDataManager.loadAssetsFromFile(applicationContext, "quotes.json")
        }
        setContent {
            QuotifyTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    if(QuoteDataManager.isDataLoaded.value){
        if (QuoteDataManager.currentScreen.value == Screen.LISTING){
            QuoteListScreen(data = QuoteDataManager.quoteList.toTypedArray()) {
                QuoteDataManager.switchScreen(it)
            }
        }else{
            QuoteDataManager.currentQuote?.let { QuoteDetailScreen(it) }
        }
    }else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(text = "Loading....", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

enum class Screen{
    LISTING,
    DETAIL
}