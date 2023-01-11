package com.sinyee.babyb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.sinyee.babyb.databinding.FragmentOnnnnBinding
import com.sinyee.babyb.oothththt.Constance
import com.sinyee.babyb.oothththt.DataStoreManager
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.firstStartDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.instIDDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.randomUUIDDataStoreKey
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class OnnnnFragment : Fragment() {
    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentOnnnnBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentOnnnnBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnnnnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        try {

            initOneSignal()

            initMyTrackerAndGoNext()


        } catch (e: Exception) {
            detdefdfe()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun initMyTrackerAndGoNext() {
        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(requireContext())
        trackerConfig.isTrackingLaunchEnabled = true

        lifecycleScope.launch {
            val isFirstStart =
                dataManager.readStringFromDataStore(key = firstStartDataStoreKey)


            lifecycleScope.launch {
                if (isFirstStart == null) {
                    val IDIN = UUID.randomUUID().toString()

                    trackerParams.customUserId = IDIN
                    dataManager.saveStringToDataStore(
                        key = randomUUIDDataStoreKey,
                        value = IDIN
                    )
                    dataManager.saveStringToDataStore(
                        key = instIDDataStoreKey,
                        value = instID
                    )
                    dataManager.saveStringToDataStore(
                        key = firstStartDataStoreKey,
                        value = "noope"
                    )
                } else {
                    val customUserId =
                        dataManager.readStringFromDataStore(key = randomUUIDDataStoreKey)
                            ?: Constance.KEY_NO_DATA
                    trackerParams.customUserId = customUserId

                }
                MyTracker.initTracker(Constance.MY_TRACKER_ID, requireActivity().application)
                findNavController().navigate(R.id.action_onnnnFragment_to_tvvvvvvFragment)
            }
        }
    }

    private fun initOneSignal() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(Constance.ONE_SINGNAL_ID)
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
        requireActivity().onBackPressed()
    }


}