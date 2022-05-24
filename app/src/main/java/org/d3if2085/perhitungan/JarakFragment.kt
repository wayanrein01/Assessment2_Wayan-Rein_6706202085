package org.d3if2085.perhitungan

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.d3if2085.perhitungan.database.RoomDB
import org.d3if2085.perhitungan.databinding.FragmentJarakBinding
import org.d3if2085.perhitungan.repository.PerhitunganRepository
import org.d3if2085.perhitungan.viemodel.PerhitunganViewModel
import org.d3if2085.perhitungan.viemodel.PerhitunganViewModelFactory


class JarakFragment : Fragment() {

    private lateinit var binding: FragmentJarakBinding
    private val viewModel: PerhitunganViewModel by lazy {
        val DB = RoomDB.getInstance(requireContext())
        val repository = PerhitunganRepository(DB.perhitunganDao)
        val factory = PerhitunganViewModelFactory(repository)
        ViewModelProvider(this, factory)[PerhitunganViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJarakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = "Menghitung Jarak"
        binding.Hitung.setOnClickListener { Perhitungan() }
    }

    private fun Perhitungan() {
        val kecepatan = binding.kecepatanEditText.text.toString()
        if (TextUtils.isEmpty(kecepatan)) {
            Toast.makeText(this.requireContext(), R.string.kecepatan_invalid, Toast.LENGTH_LONG)
                .show()
            return
        }

        val waktu = binding.waktuEditText.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this.requireContext(), R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hs = kecepatan.toDouble() * waktu.toDouble()
        binding.hsTextView.text = getString(R.string.hasil_jarak, hs.toDouble())

        val perhitungan = org.d3if2085.perhitungan.database.entity.Perhitungan(
            0L,
            hs.toFloat(),
            "jarak",
            kecepatan.toFloat(),
            waktu.toFloat()
        )
        viewModel.insertPerhitungan(perhitungan)

    }
}