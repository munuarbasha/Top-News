package com.news.topnews.splashscreen

import com.news.topnews.base.BaseVMTest
import com.news.topnews.common.runBlockingTest
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.splash.viewmodel.SplashScreenViewModel
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