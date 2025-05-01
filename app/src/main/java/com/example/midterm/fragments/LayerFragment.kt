package com.example.midterm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.midterm.R
import com.example.midterm.VPfragments.approved
import com.example.midterm.VPfragments.rejected
import com.example.midterm.VPfragments.review
import com.example.midterm.ViewPagerAdapter.ViewPagerAdapter
import com.example.midterm.databinding.FragmentLayerBinding
import com.google.android.material.tabs.TabLayoutMediator


class LayerFragment : Fragment() {
lateinit var binding: FragmentLayerBinding
lateinit var fragmentManager: FragmentManager

private val fList= listOf(
    approved.newInstance(),
    rejected.newInstance(),
    review.newInstance()
)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentLayerBinding.inflate(inflater, container, false)
        return binding.root

      binding.SubmitLeaveBtn.setOnClickListener(){ /* dialog fragmentze gadayvana */
        loadFragment(DialogFragment.newInstance())
    }
}
private fun loadFragment(f : Fragment){
    parentFragmentManager.beginTransaction().replace(R.id.placeHolder,f).commit()
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVP()
    }
    private fun initVP()= with(binding){
if(isAdded){

    val adapter = ViewPagerAdapter(requireActivity(),fList)
    VP.adapter= adapter

    val tabTitles = listOf("Review","Approved", "Rejected")

    TabLayoutMediator(tabLayout, VP){ tab, position->
        tab.text = tabTitles[position]
    }.attach()
}


    }





    companion object {

        fun newInstance() = LayerFragment()
    }
}