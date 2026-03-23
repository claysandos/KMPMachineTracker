package com.example.kmpmachinetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kmpmachinetracker.databinding.FragmentHomeBinding

/**
 * Clay Sandos - Karl Malone Powersports SLC
 * March 23, 2026
 *
 * Home fragment representing the home navigation menu.
 * - Add Service Machine: Navigate to add service machine fragment such that the user can add a new active service machine to be prepared
 * - Add Sold Machine: Navigate to add sold machine fragment such that the user can add a new active sold machine to be prepared
 * - Active Service Machines: Navigate to active service machines fragment such that the user can see/edit/remove active service machines to be prepared
 * - Active Sold Machines: Navigate to active sold machines fragment such that the user can see/edit/remove active sold machines to be prepared
 */
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeFragmentBinding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Access to MainActivity navigation function
        val mainActivity = activity as? MainActivity

        val addServicePullupButton = homeFragmentBinding.addServiceMachine
        addServicePullupButton.setOnClickListener{
            mainActivity?.navigateFragment(AddServiceMachineFragment(), "Add Service Machine")
        }

        val addSoldMachineButton = homeFragmentBinding.addSoldMachine
        addSoldMachineButton.setOnClickListener{
            mainActivity?.navigateFragment(AddSoldMachineFragment(), "Add Sold Machine")
        }

        val activeServicePullupsButton = homeFragmentBinding.activeServiceMachines
        activeServicePullupsButton.setOnClickListener{
            mainActivity?.navigateFragment(ActiveServiceMachinesFragment(), "Active Service Machines")
        }

        val activeSoldMachinesButton = homeFragmentBinding.activeSoldMachines
        activeSoldMachinesButton.setOnClickListener{
            mainActivity?.navigateFragment(ActiveSoldMachinesFragment(), "Active Sold Machines")
        }

        // Inflate the layout for this fragment
        return homeFragmentBinding.root
    }
}