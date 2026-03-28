package com.example.kmpmachinetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmpmachinetracker.databinding.FragmentActiveServiceMachinesBinding
import kotlinx.coroutines.launch

/**
 * Clay Sandos - Karl Malone Powersports SLC
 * March 23, 2026
 *
 * ActiveServiceMachines fragment representing the list of active service machines to be prepared.
 */
class ActiveServiceMachinesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Access to MainActivity navigation function
        val mainActivity = activity as? MainActivity

        // Get inflated fragment view binding
        val activeServiceMachinesListBinding = FragmentActiveServiceMachinesBinding.inflate(inflater, container, false)

        // Get active service machine list recycler
        val activeServiceMachineRecycler = activeServiceMachinesListBinding.activeServiceMachineRecycler

        val activeServiceMachineListAdapter = ActiveServiceMachinesAdapter(listOf(), {
            mainActivity?.activeServiceMachineViewModel?.removeActiveServiceMachine(it)
        }, {
            mainActivity?.activeServiceMachineViewModel?.toggleReadyActiveServiceMachine(it)
        })

        // Set layout manager
        activeServiceMachineRecycler.layoutManager = LinearLayoutManager(context)
        // Set adapter
        activeServiceMachineRecycler.adapter = activeServiceMachineListAdapter

        // Coroutine to update active service machine list recycler
        viewLifecycleOwner.lifecycleScope.launch {
            // Repeat on lifecycle started
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Use contact list flow
                mainActivity?.activeServiceMachineViewModel?.observableActiveServiceMachineList?.collect {
                    // Use contact list adapter
                    activeServiceMachineListAdapter.updateContactList(it)
                }
            }
        }

        // Inflate the layout for this fragment
        return activeServiceMachinesListBinding.root
    }
}