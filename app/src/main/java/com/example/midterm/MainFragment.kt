package com.example.midterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midterm.databinding.FragmentMainBinding
import com.example.midterm.fragments.CalendarFragment
import com.example.midterm.fragments.HomeFragment
import com.example.midterm.fragments.LayerFragment
import com.example.midterm.fragments.NoteFragment
import com.example.midterm.fragments.ReceiptFragment


class MainFragment : Fragment() {

     lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container, false)
        return binding.root


    }





    private fun loadFragment(f : Fragment){
        parentFragmentManager.beginTransaction().replace(R.id.placeHolder,f).commit()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        loadFragment(HomeFragment.newInstance())

        bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.layer-> { /* mtavari design  */
                    loadFragment(LayerFragment.newInstance())
                    true
            }

                    R.id.home-> {
                        loadFragment(HomeFragment.newInstance())
                        true
                    }
                R.id.calendar-> {
                    loadFragment(CalendarFragment.newInstance())
                    true
                }
                R.id.note-> {
                    loadFragment(NoteFragment.newInstance())
                    true
                }
                R.id.receipt-> {
                    loadFragment(ReceiptFragment.newInstance())
                    true
                }

                else -> {
                loadFragment(HomeFragment.newInstance())
                true}
            }
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}