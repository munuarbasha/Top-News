package com.news.topnews.presentation.splash.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.news.topnews.common.base.BaseBindingFragment
import com.news.topnews.common.extensions.show
import com.news.topnews.common.utils.AlertDialogUtils
import com.news.topnews.common.utils.DeviceRootChecker
import com.news.topnews.domain.common.ResponseWrapper
import com.news.topnews.presentation.R
import com.news.topnews.presentation.databinding.FragmentSplashScreenBinding
import com.news.topnews.presentation.splash.viewmodel.SplashScreenViewModel

/**
 * Fragment to show application splash screen
 */
class SplashFragment : BaseBindingFragment<FragmentSplashScreenBinding>() {

    private val splashScreenViewModel by viewModels<SplashScreenViewModel>()

    override fun setUpView() {
        checkDeviceRootStatus()
    }

    /**
     * Verify root status
     */
    private fun checkDeviceRootStatus() {
        if (DeviceRootChecker.isRooted(requireContext())) {
            AlertDialogUtils.showError(
                requireContext(),
                getString(R.string.device_rooted_message)
            ) {
                requireActivity().finish()
            }
        } else {
            initObserver()
        }
    }

    /**
     * Live data observer from ViewModel
     */
    private fun initObserver() {
        splashScreenViewModel.splashStatus.observe(this) {
            when (it) {
                is ResponseWrapper.Loading -> binding.loadingProgressBar.show()
                else -> {
                    navigateToNewsListScreen()
                }
            }
        }
    }

    private fun navigateToNewsListScreen() {
        findNavController().navigate(
            R.id.action_to_topNewsListFragment,
            null,
            null,
            null
        )
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashScreenBinding
        get() = FragmentSplashScreenBinding::inflate

}