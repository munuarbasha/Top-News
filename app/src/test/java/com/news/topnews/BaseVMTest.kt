package com.news.topnews

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class BaseVMTest {

    // Set the main coroutines dispatcher for unit testing.
    @get:Rule
    var testCoroutineRule = MainCoroutineRules()

}