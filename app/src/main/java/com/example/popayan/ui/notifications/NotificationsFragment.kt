package com.example.popayan.ui.notifications

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
import com.example.popayan.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var mediaPlayer: MediaPlayer

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnCaldas.setOnClickListener{
            val intent = Intent(requireContext(), MapsActivity::class.java)
            intent.putExtra("latitud",   2.442081779393574)
            intent.putExtra("longitud", -76.60625244778097)
            intent.putExtra("title","Parque Caldas")
            startActivity(intent)
        }


        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.blink)
        mediaPlayer.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


        mediaPlayer.release()
    }
}
