package org.d3if2085.perhitungan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if2085.perhitungan.adapter.HistoryAdapter
import org.d3if2085.perhitungan.database.RoomDB
import org.d3if2085.perhitungan.databinding.FragmentHistoryBinding
import org.d3if2085.perhitungan.repository.PerhitunganRepository
import org.d3if2085.perhitungan.viemodel.PerhitunganViewModel
import org.d3if2085.perhitungan.viemodel.PerhitunganViewModelFactory


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: PerhitunganViewModel by lazy {
        val DB = RoomDB.getInstance(requireContext())
        val repository = PerhitunganRepository(DB.perhitunganDao)
        val factory = PerhitunganViewModelFactory(repository)
        ViewModelProvider(this, factory)[PerhitunganViewModel::class.java]
    }

    private lateinit var historyAdapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        historyAdapter = HistoryAdapter(viewModel)
        with(binding.rvHistory) {
            adapter = historyAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())

        }
        viewModel.gertAllPerhitungan.observe(viewLifecycleOwner) {
            historyAdapter.submitList(it)
        }
    }

}