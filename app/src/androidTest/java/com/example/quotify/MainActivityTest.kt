package com.example.quotify


import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withText
import kotlinx.coroutines.withContext
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNextButton_expected_correctQuote() {
        /*onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(typeText(""))

        onView(withId(R.id.btnNext)).check(matches(withText("Dream big and dare to fail.")))*/
    }

    @Test
    fun testShareButton_expected_intentChooser() {

        /*Intents.init()

        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.fab)).perform(click())
        intended(expected)
        Intents.release()*/

    }

  
}