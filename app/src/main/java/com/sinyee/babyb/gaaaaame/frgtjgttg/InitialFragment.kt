package com.sinyee.babyb.gaaaaame.frgtjgttg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sinyee.babyb.R
import com.sinyee.babyb.databinding.FragmentInitialBinding

class InitialFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentInitialBinding.inflate(inflater, container, false)
        return binding.root
    }

    val gthhyhy = "sasfgthyhyhhyrgtffrrffr"
    val f5 = "sasffikikikkirgttgrffr"

    var _biiiiiiinding: FragmentInitialBinding? = null
    val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentInitialBinding = null")


    val f6 = "sasffhyujujugtgtrrffr"
    var currentBet = 500

    val gtgtgtgt = "juujujujjuuj"

    val ggtgtgt = "fgthyujuu"
    val bgbgbnnn = "hyjujuujuj"

    val f9 = "sasffhyjujujrrffr"


    val f8 = "sasffrkikiikgtgtgtrffr"

    val gtgtgtgtgt = ggtgtgt +bgbgbnnn+gthhyhy+f5+f6+gtgtgtgt+f8+f9

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (f8 == "ffffffffff"){
            Toast.makeText(requireContext(), "res is $gtgtgtgtgt", Toast.LENGTH_SHORT).show()
        }

        binding.mainLottieRight.setOnClickListener {
            findNavController().navigate(R.id.action_initialFragment_to_chooseImageFragment)
        }


        super.onViewCreated(view, savedInstanceState)
    }





    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        _biiiiiiinding = null
        super.onDestroy()
    }




}