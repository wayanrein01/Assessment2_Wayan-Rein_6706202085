package org.d3if2085.perhitungan

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if2085.perhitungan.databinding.FragmentWaktuBinding


class waktuFragment : Fragment() {
        private  lateinit var binding: FragmentWaktuBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentWaktuBinding.inflate(inflater,container,false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            (activity as AppCompatActivity).supportActionBar?.title = "Menghitung Waktu"
            binding.hitung.setOnClickListener { Perhitungan() }

        }

        private fun Perhitungan() {
            val jarak = binding.JarakTextNumber.text.toString()
            if (TextUtils.isEmpty(jarak)) {
                Toast.makeText(this.requireContext(), R.string.kecepatan_invalid, Toast.LENGTH_LONG).show()
                return
            }

            val kecepatan = binding.KecepatanTextNumber2.text.toString()
            if (TextUtils.isEmpty(kecepatan)) {
                Toast.makeText(this.requireContext(), R.string.waktu_invalid, Toast.LENGTH_LONG).show()
                return
            }
            val hs = jarak.toDouble() / kecepatan.toDouble()
            binding.hasilWaktuTextView.text = getString(R.string.hasil_jarak, hs.toDouble())


        }
    }