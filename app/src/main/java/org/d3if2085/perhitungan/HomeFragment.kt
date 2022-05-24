package org.d3if2085.perhitungan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import org.d3if2085.perhitungan.databinding.FragmentHomeBinding
import org.d3if2085.perhitungan.databinding.FragmentKecepatanBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = "Home"
        binding.menghitungJarak.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kecepatanFragment)
        }
        binding.waktu.setOnClickListener {
            findNavController().navigate (R.id.action_homeFragment_to_waktuFragment2)
        }
        binding.kecepatan.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kecepatanFragment2)
        }
        binding.buttonTohistory.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)

            }
    }

}