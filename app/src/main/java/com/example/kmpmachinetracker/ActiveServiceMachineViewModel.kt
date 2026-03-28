package com.example.kmpmachinetracker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class ActiveServiceMachine(val id: Int, val machineBrand: String, val machineYear: String, val machineModel: String, val customerName: String, val machineColor: String, val ready: Boolean, val time: String)

class ActiveServiceMachineViewModel : ViewModel() {
    // MODEL - Stores actual active service machine list data (mutable)
    private val actualActiveServiceMachineList: MutableStateFlow<List<ActiveServiceMachine>> =
        MutableStateFlow(
            listOf()
        )

    // VM - Stores read-only active service machine list data that view can see (immutable)
    val observableActiveServiceMachineList = actualActiveServiceMachineList as StateFlow<List<ActiveServiceMachine>>

    fun addActiveServiceMachine(machineBrand: String, machineYear: String, machineModel: String, customerName: String, machineColor: String, ready: Boolean, time: String){
        actualActiveServiceMachineList.update {
            // Create new list with the new service machine
                list ->
            list + ActiveServiceMachine(actualActiveServiceMachineList.value.size + 1, machineBrand, machineYear, machineModel, customerName, machineColor, ready, time)
        }
    }

    fun removeActiveServiceMachine(selectedMachine: ActiveServiceMachine){
        actualActiveServiceMachineList.update {
            // Create new list without the service machine
                list ->
            list.filter { x -> x != selectedMachine }
        }
    }

    fun toggleReadyActiveServiceMachine(selectedMachine: ActiveServiceMachine){
        actualActiveServiceMachineList.value = actualActiveServiceMachineList.value.map { machine ->
            // Toggle active service machine ready status
            if(machine.id == selectedMachine.id){
                machine.copy(ready = !machine.ready)
            }else {
                machine
            }
        }
    }
}

