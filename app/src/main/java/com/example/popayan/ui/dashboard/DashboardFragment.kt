package com.example.popayan.ui.dashboard

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
import com.example.popayan.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var mediaPlayer: MediaPlayer

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnMorro.setOnClickListener{
            val intent = Intent(requireContext(), MapsActivity::class.java)
            intent.putExtra("latitud",   2.4448618598754495)
            intent.putExtra("longitud", -76.60014736312085)
            intent.putExtra("title","Morro de Tulcan")
            startActivity(intent)
        }

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.lost)
        mediaPlayer.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        mediaPlayer.release()
    }
}
