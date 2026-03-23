package com.example.kmpmachinetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Clay Sandos - Karl Malone Powersports SLC
 * March 23, 2026
 *
 * ActiveSoldMachines fragment representing the list of active sold machines to be prepared.
 */
class ActiveSoldMachinesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_sold_machines, container, false)
    }
}