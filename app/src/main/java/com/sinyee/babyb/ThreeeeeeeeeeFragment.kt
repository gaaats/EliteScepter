package com.sinyee.babyb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.sinyee.babyb.databinding.FragmentThreeeeeeeeeeBinding
import com.sinyee.babyb.oothththt.Constance
import com.sinyee.babyb.oothththt.DataStoreManager
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.appsCheckerDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.namingDataStoreKey
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class ThreeeeeeeeeeFragment : Fragment() {
    var temNaming = "loading"

    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentThreeeeeeeeeeBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentThreeeeeeeeeeBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThreeeeeeeeeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            lifecycleScope.launch {
                val isAppsLaunched =
                    dataManager.readStringFromDataStore(key = appsCheckerDataStoreKey)
                        ?: Constance.KEY_NO_DATA

                delay(500)

                when (isAppsLaunched) {
                    "yes" -> {
                        launchApps()
                    }
                    "no" -> {
                        findNavController().navigate(R.id.action_threeeeeeeeeeFragment_to_foooooooooorFragment)

                    }
                    Constance.KEY_NO_DATA -> {
                        findNavController().navigate(R.id.action_threeeeeeeeeeFragment_to_initialFragment)
                    }

                }

            }


        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private suspend fun launchApps() {
        initAppsFlyerLibeer(context = requireActivity())

        val preNaming = dataManager.readStringFromDataStore(namingDataStoreKey)

        while (true) {
            if (temNaming != "loading") {
                delay(1000)
                if (preNaming == null) {
                    dataManager.saveStringToDataStore(key = namingDataStoreKey, value = temNaming)
                }
                delay(500)
                findNavController().navigate(R.id.action_threeeeeeeeeeFragment_to_foooooooooorFragment)
                break
            } else {
                delay(1000)
            }
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun kpkpkpkp() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }


    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().finish()
    }

    private fun initAppsFlyerLibeer(context: Context) {
        AppsFlyerLib.getInstance()
            .init(Constance.KEY_APPS_ID, conversionDataListener, context)
        AppsFlyerLib.getInstance().start(context)
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString().apply {
                temNaming = this

            }
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(p0: String?) {
        }
    }


}