package org.d3if2085.perhitungan

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if2085.perhitungan.databinding.FragmentJarakBinding
import org.d3if2085.perhitungan.databinding.FragmentKecepatanBinding


class KecepatanFragment : Fragment() {
    private lateinit var binding: FragmentKecepatanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKecepatanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = "Menghitung Kecepatan"
        binding.hasil.setOnClickListener { Perhitungan() }
    }

    private fun Perhitungan() {
        val jarak = binding.jarakTextNumber.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(this.requireContext(), R.string.kecepatan_invalid, Toast.LENGTH_LONG)
                .show()
            return
        }

        val waktu = binding.waktuTextNumber2.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this.requireContext(), R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hs = jarak.toDouble() / waktu.toDouble()
        binding.hasilKecepatanTextView.text = getString(R.string.hasil_jarak, hs.toDouble())
    }
}