package vdo.ai.sample.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vdo.ai.android.core.VdoBannerAd
import vdo.ai.android.core.listeners.VdoBannerAdListener
import vdo.ai.android.core.models.VdoAdError
import vdo.ai.android.core.utils.VdoAdSize
import vdo.ai.android.core.utils.VdoKUtils
import vdo.ai.sample.kotlin.databinding.ActivityBannerBinding

class BannerFragment : Fragment() {

    private var _binding: ActivityBannerBinding? = null
    private val binding get() = _binding!!
    private val builder = StringBuilder()
    private var bannerAd: VdoBannerAd? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityBannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        example()
    }

    private fun example() {
        bannerAd = VdoBannerAd.VdoBannerAdBuilder()
            .withContext(requireContext()) // Use requireContext()
            .setEnvironment(BuildConfig.BUILD_TYPE)
            .setBannerView(binding.bannerAdsContainer)
            .setTagName("in-app-sample-b-Z1")
            .setAllowRefresh(false)
            .setAddSize(VdoAdSize.BANNER)
            .setListener(object : VdoBannerAdListener {
                override fun onAdClicked() {
                    builder.append("Add Clicked \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdClosed() {
                    builder.append("Add Closed \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdFailedToLoad(adError: VdoAdError?) {
                    builder.append("Add Fail to load \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdImpression() {
                    builder.append("Add impression \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdLoaded() {
                    builder.append("Add loaded \n")
                    binding.textView.text = builder.toString()
                }

                override fun onAdOpened() {
                    builder.append("Add opened \n")
                    binding.textView.text = builder.toString()
                }
            }).build()
    }

    override fun onResume() {
        super.onResume()
        VdoKUtils.onResume(requireActivity(), bannerAd) // Use requireActivity()
    }

    override fun onPause() {
        super.onPause()
        VdoKUtils.onPause(requireActivity(), bannerAd) // Use requireActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        VdoKUtils.destroyBanner(bannerAd)
        _binding = null
    }
}