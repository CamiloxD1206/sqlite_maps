package com.example.popayan.ui.notifications

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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


        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.blink)
        mediaPlayer.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        // Liberar recursos del MediaPlayer cuando el fragmento es destruido
        mediaPlayer.release()
    }
}
