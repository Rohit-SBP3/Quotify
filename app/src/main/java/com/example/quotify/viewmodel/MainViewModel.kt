package com.example.quotify.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quotify.Screen
import com.example.quotify.model.Quote
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val context: Context): ViewModel() {

    var quoteList = emptyList<Quote>()
    private var currentQuoteIndex: Int = 0
    var isDataLoaded =  mutableStateOf(false)
    var currentScreen = mutableStateOf(Screen.LISTING)
    var currentQuote: Quote? = null

    init {
        CoroutineScope(Dispatchers.IO).launch {
            quoteList = loadQuoteFromAssets("quotes.json")
        }
    }

    private fun loadQuoteFromAssets(fileName: String): List<Quote> {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java).toList()
        isDataLoaded.value = true
    }

    fun populateQuotes(quotes: List<Quote>){
        quoteList = quotes
    }

    fun fetchCurrentQuote(): Quote? {
        currentQuote = quoteList[currentQuoteIndex]
        return currentQuote
    }

    fun getPreviousQuote(): Quote {
        if(currentQuoteIndex == 0) return quoteList[currentQuoteIndex]
        return quoteList[--currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if(currentQuoteIndex == quoteList.size-1) return quoteList[currentQuoteIndex]
        return quoteList[++currentQuoteIndex]
    }

    fun switchScreen(quote: Quote){
        if (currentScreen.value == Screen.LISTING){
            currentQuote = quote
            currentScreen.value = Screen.DETAIL
        }
        else currentScreen.value = Screen.LISTING
    }




}