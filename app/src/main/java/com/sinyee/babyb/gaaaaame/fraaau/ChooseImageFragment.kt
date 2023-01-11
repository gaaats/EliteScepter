package com.sinyee.babyb.gaaaaame.fraaau

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sinyee.babyb.R
import com.sinyee.babyb.databinding.FragmentChooseImageBinding


class ChooseImageFragment : Fragment() {

    private var userLogo: Drawable? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentChooseImageBinding.inflate(inflater, container, false)
        return binding.root
    }


    var _biiiiiiinding: FragmentChooseImageBinding? = null
    val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentChooseImageBinding = null")

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


        binding.img1.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g4).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img2.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g2).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img3.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g3).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img4.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g1).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img5.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g5).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img6.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g6).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img7.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g7).also {
                binding.userLogo.setImageDrawable(it)
            }
        }
        binding.img8.setOnClickListener {
            userLogo = ContextCompat.getDrawable(requireActivity(), R.drawable.g8).also {
                binding.userLogo.setImageDrawable(it)
            }
        }

        binding.btnOkkkkApp.setOnClickListener {
            if (userLogo != null){
                findNavController().navigate(R.id.action_chooseImageFragment_to_loadingGameFragment)
            } else {
                Toast.makeText(requireContext(), "Firstly choose avatar", Toast.LENGTH_SHORT).show()
            }
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