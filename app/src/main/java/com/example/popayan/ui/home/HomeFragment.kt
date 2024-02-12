package com.example.popayan.ui.home

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.popayan.MapsActivity
import com.example.popayan.R
import com.example.popayan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var mediaPlayer: MediaPlayer

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnSena.setOnClickListener{
            val intent = Intent(requireContext(), MapsActivity::class.java)
            intent.putExtra("latitud",    2.4834960102086443)
            intent.putExtra("longitud", -76.56174047661578)
            intent.putExtra("title","Centro de Teleinformatica y Produccion Industrial")
            startActivity(intent)
        }


        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.nublado)
        mediaPlayer.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


        mediaPlayer.release()
    }
}
