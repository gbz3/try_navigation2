package com.example.trynavigation2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.trynavigation2.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
        val btn2dash = root.findViewById<Button>(R.id.button1)
        val btn2notif = root.findViewById<Button>(R.id.button2)
        btn2dash.setOnClickListener { findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard) }
        btn2notif.setOnClickListener { findNavController().navigate(R.id.action_navigation_home_to_navigation_notifications) }
        return root
    }
}