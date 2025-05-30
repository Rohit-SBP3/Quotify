package com.example.quotify

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.quotify.model.Quote
import com.google.gson.JsonSyntaxException
import org.junit.Test
import org.junit.Assert.*
import java.io.FileNotFoundException

class QuoteDataManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuotes_InvalidFileName_expected_FileNotFoundException() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        QuoteDataManager.loadAssetsFromFile(context,"")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuotes_InvalidJson_expected_JsonSyntaxException() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        QuoteDataManager.loadAssetsFromFile(context,"mal.json")
    }

    @Test
    fun populateQuotes_ValidJson_expected_Count() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        QuoteDataManager.loadAssetsFromFile(context,"quotes.json")
        assertEquals(34, QuoteDataManager.quoteList.size)
    }

    @Test
    fun getPreviousQuote_expected_CorrectQuote() {

        // Arrange
        QuoteDataManager.quoteList = listOf<Quote>(
            Quote("Hello","Rohit"),
            Quote("hii","Man")
        )

        // Act
        val quote = QuoteDataManager.getPreviousQuote()

        // Assert
        assertEquals("Rohit", quote?.author)
    }

    @Test
    fun getNextQuote_expected_CorrectQuote() {

        // Arrange
        QuoteDataManager.quoteList = listOf<Quote>(
            Quote("Hello","Rohit"),
            Quote("hii","Man")
        )

        // Act
        val quote = QuoteDataManager.getPreviousQuote()

        // Assert
        assertEquals("Man", quote?.author)

    }

}