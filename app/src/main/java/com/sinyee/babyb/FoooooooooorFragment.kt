package com.sinyee.babyb

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sinyee.babyb.brorororo.BrooovserActivity
import com.sinyee.babyb.databinding.FragmentFoooooooooorBinding
import com.sinyee.babyb.oothththt.Constance
import com.sinyee.babyb.oothththt.DataStoreManager
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.listOfAllGeoDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.namingDataStoreKey
import com.sinyee.babyb.oothththt.DataStoreManager.Companion.userGeoDataStoreKey
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class FoooooooooorFragment : Fragment() {
    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentFoooooooooorBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentFoooooooooorBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoooooooooorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            lifecycleScope.launch {
                val naming = dataManager.readStringFromDataStore(key = namingDataStoreKey)
                    ?: Constance.KEY_NO_DATA
                val geoUser =
                    dataManager.readStringFromDataStore(key = userGeoDataStoreKey) ?: "no geeeeo"
                val listGeo = dataManager.readStringFromDataStore(key = listOfAllGeoDataStoreKey)
                    ?: Constance.KEY_NO_DATA

                delay(1000)

                delay(1000)

                if (naming.contains(Constance.KEY_TDB2gtgt) || listGeo.contains(geoUser)) {
                    goToVebViev()
                } else {
                    findNavController().navigate(R.id.action_foooooooooorFragment_to_initialFragment)
                }
            }


        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun goToVebViev() {
        val intent = Intent(requireActivity(), BrooovserActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().finish()
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}