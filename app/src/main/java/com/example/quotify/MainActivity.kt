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
import androidx.lifecycle.ViewModelProvider
import com.example.quotify.view.QuoteDetailScreen
import com.example.quotify.view.QuoteListScreen
import com.example.quotify.ui.theme.QuotifyTheme
import com.example.quotify.viewmodel.MainViewModel
import com.example.quotify.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        setContent {
            QuotifyTheme {
                App(mainViewModel)
            }
        }
    }
}

@Composable
fun App(mainViewModel: MainViewModel) {
    if(mainViewModel.isDataLoaded.value){
        if (mainViewModel.currentScreen.value == Screen.LISTING){
            QuoteListScreen(data = mainViewModel.quoteList.toTypedArray()) {
                mainViewModel.switchScreen(it)
            }
        }else{
            mainViewModel.currentQuote?.let { QuoteDetailScreen(mainViewModel,it) }
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

// LiveData
/*
*
*
* */

enum class Screen{
    LISTING,
    DETAIL
}