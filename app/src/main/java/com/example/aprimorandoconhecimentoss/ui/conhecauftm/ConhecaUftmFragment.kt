package com.example.aprimorandoconhecimentoss.ui.conhecauftm

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.adapters.SliderAdapter
import com.example.aprimorandoconhecimentoss.databinding.FragmentConhecauftmBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class ConhecaUftmFragment : Fragment() {

    private var _binding: FragmentConhecauftmBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_conhecauftm, container, false)
        val ids_images_uftm = intArrayOf(
            R.drawable.uftm1,
            R.drawable.uftm2,
            R.drawable.uftm3
        )

        val sliderView: SliderView = view.findViewById<View>(R.id.sliderUftm) as SliderView
        val sliderAdapter: SliderAdapter = SliderAdapter(ids_images_uftm)


        Log.d("inicializou", "sliderView inicializado")
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.indicatorSelectedColor = Color.WHITE;
        sliderView.indicatorUnselectedColor = Color.GRAY;
        sliderView.scrollTimeInSec = 3;
        sliderView.startAutoCycle()
        sliderView.setSliderAdapter(sliderAdapter)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}