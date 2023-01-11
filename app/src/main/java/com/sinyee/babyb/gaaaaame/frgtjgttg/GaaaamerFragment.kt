package com.sinyee.babyb.gaaaaame.frgtjgttg


import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.sinyee.babyb.databinding.FragmentGaaaamerBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class GaaaamerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gaaaamerBinding = FragmentGaaaamerBinding.inflate(inflater, container, false)
        return binding.root
    }

    var bggbgbbgbg = 0.05f
    var hyjuujujujujkiik = 0.05f

    var hyjujuujujujuj = false

    private val gbghyhyhyhyhy = arrayOf(700, 1000, 100, 200, 500, 155, 80, 999, 777)
    private val hyhyjukikik = gbghyhyhyhyhy.clone()
    private val juukiikloolikikikki = 360 / gbghyhyhyhyhy.size
    private var hyjuujujhyhyhy = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {

            initExitBtnfrgttg()
            bgnhhyhyyhyh()
            dfeghjk()
            binding.btnGoSpin.setOnClickListener {
                if (!hyjuujujhyhyhy) {
                    frghj()
                    hyjuujujhyhyhy = true
                }
            }

        } catch (e: Exception) {
            fgthyhy555()
        }

        super.onViewCreated(view, savedInstanceState)
    }


    private var gaaaamerBinding: FragmentGaaaamerBinding? = null
    private val binding get() = gaaaamerBinding ?: throw RuntimeException("FragmentGaaaamerBinding = null")

    private fun initExitBtnfrgttg() {
        binding.btnImgExitRaitFragment.setOnClickListener {
            gthyhujukiikik()
        }
    }

    private fun frghj() {
        val winnerNumber = Random.nextInt(gbghyhyhyhyhy.size - 1)

        val needAddRotate = (360 - winnerNumber * juukiikloolikikikki).toFloat()
        val rotateAnimation = RotateAnimation(
            0f,
            (360f * gbghyhyhyhyhy.size) + needAddRotate,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimation.apply {
            duration = 1000
            fillAfter = true
            interpolator = DecelerateInterpolator()
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    val edfrgthjk = gbghyhyhyhyhy[winnerNumber]
                    Toast.makeText(
                        requireContext(),
                        "You winn $edfrgthjk$ points",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    hyjuujujhyhyhy = false
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            binding.imgWheelElementMain.startAnimation(rotateAnimation)
        }
    }

    override fun onDestroy() {
        gaaaamerBinding = null
        super.onDestroy()
    }

    private fun dfeghjk() {
        for (i in gbghyhyhyhyhy.indices) {
            hyhyjukikik[i] = (i + 1) * juukiikloolikikikki
        }
    }

    private fun gthyhujukiikik() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                uhrfurhrfurhuhrhurf()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    private fun bgnhhyhyyhyh() {
        if (!hyjujuujujujuj){
            lifecycleScope.launch {
                hyjujuujujujuj = !hyjujuujujujuj
                while (true) {
                    binding.btnGoSpin.alpha = bggbgbbgbg
                    if (bggbgbbgbg >= 1f) {
                        froijrjrfrjgjthtughthtug()
                    }
                    if (bggbgbbgbg <= 0.1f) {
                        hyjuujujujujkiik = 0.05f
                    }
                    delay(20)
                    fjjijrijgitjhtghguthhut()
                }
            }

        }

    }

    private fun fjjijrijgitjhtghguthhut() {
        bggbgbbgbg += hyjuujujujujkiik
    }

    private fun froijrjrfrjgjthtughthtug() {
        hyjuujujujujkiik = -0.05f
    }

    private fun fgthyhy555() {
        frjrfrfjrjijrfjirfjrfjr()
        uhrfurhrfurhuhrhurf()
    }

    private fun uhrfurhrfurhuhrhurf() {
        requireActivity().onBackPressed()
    }

    private fun frjrfrfjrjijrfjirfjrfjr() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
    }
}