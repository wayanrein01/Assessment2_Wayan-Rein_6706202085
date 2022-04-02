package org.d3if2085.perhitungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if2085.perhitungan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Hitung.setOnClickListener { Perhitungan() }


    }

    private fun Perhitungan() {
        val kecepatan = binding.kecepatanEditText.text.toString()
        if (TextUtils.isEmpty(kecepatan)) {
            Toast.makeText(this, R.string.kecepatan_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val waktu = binding.waktuEditText.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hs = kecepatan.toDouble() * waktu.toDouble()
        binding.hsTextView.text = getString(R.string.hasil_jarak, hs.toDouble())


    }
}