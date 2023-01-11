package com.sinyee.babyb.gaaaaame.frrrrrr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sinyee.babyb.R
import com.sinyee.babyb.databinding.FragmentLoadingGameBinding
import kotlinx.coroutines.delay


class LoadingGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentLoadingGameBinding.inflate(inflater, container, false)
        return binding.root
    }


    var _biiiiiiinding: FragmentLoadingGameBinding? = null
    val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentLoadingGameBinding = null")

    val z = 1
    val x = 1
    val c = 1
    val v = 1
    val b = 1
    val n = 1
    val m = 1





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val oooo = z+x+c+v+b+n+m

        if (oooo == 5555){
            Toast.makeText(requireContext(), "res is $oooo", Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launchWhenCreated {
            Toast.makeText(requireContext(), "Almost done...", Toast.LENGTH_SHORT).show()
            delay(2000)
            findNavController().navigate(R.id.action_loadingGameFragment_to_gaaaamerFragment)
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