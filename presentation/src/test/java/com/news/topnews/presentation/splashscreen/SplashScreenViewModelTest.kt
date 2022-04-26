package com.news.topnews.presentation.splashscreen

import com.news.topnews.presentation.base.BaseVMTest
import com.news.topnews.presentation.common.runBlockingTest
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.presentation.splash.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SplashScreenViewModelTest : BaseVMTest() {

    private lateinit var splashScreenViewModel: SplashScreenViewModel

    @Before
    fun setUp() {
        splashScreenViewModel = SplashScreenViewModel()
    }

    @Test
    fun testSplashViewModel() {
        testCoroutineRule.runBlockingTest {
            splashScreenViewModel.loadSplashScreen()
            splashScreenViewModel.splashStatus.observeForever {
                assert(splashScreenViewModel.splashStatus.value == ResponseWrapper.Success(true))
            }
        }
    }
}