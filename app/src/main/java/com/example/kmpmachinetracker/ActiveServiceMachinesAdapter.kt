package com.example.kmpmachinetracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kmpmachinetracker.databinding.ActiveServiceMachineCardBinding

class ActiveServiceMachinesAdapter(
    private var activeServiceMachines: List<ActiveServiceMachine>,
    private val removeActiveServiceMachine: (selectedMachine: ActiveServiceMachine) -> Unit,
    private val toggleReadyActiveServiceMachine: (selectedMachine: ActiveServiceMachine) -> Unit
) : RecyclerView.Adapter<ActiveServiceMachinesAdapter.ViewHolder>() {
    /**
     * Function to update the active service machine list
     * @param updatedActiveServiceMachineList - updated active service machine list
     */
    fun updateContactList(updatedActiveServiceMachineList: List<ActiveServiceMachine>) {
        activeServiceMachines = updatedActiveServiceMachineList.sortedBy { it.time }
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class to hold a single ActiveServiceMachineCard view
     * @param activeServiceMachineCardLayoutBinding - active service machine card view layout binding
     */
    inner class ViewHolder(val activeServiceMachineCardLayoutBinding: ActiveServiceMachineCardBinding) :
        RecyclerView.ViewHolder(activeServiceMachineCardLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActiveServiceMachineCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = activeServiceMachines.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activeServiceMachine = activeServiceMachines[position]
        val layoutBinding = holder.activeServiceMachineCardLayoutBinding

        if(activeServiceMachine.machineBrand == "HONDA"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.honda)
        }else if(activeServiceMachine.machineBrand == "YAMAHA"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.yamaha)
        }else if(activeServiceMachine.machineBrand == "KAWASAKI"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.kawasaki)
        }else if(activeServiceMachine.machineBrand == "SUZUKI"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.suzuki)
        }else if(activeServiceMachine.machineBrand == "KTM"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.ktm)
        }else if(activeServiceMachine.machineBrand == "HUSQVARNA"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.husqvarna)
        }else if(activeServiceMachine.machineBrand == "GASGAS") {
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.gasgas)
        }else if(activeServiceMachine.machineBrand == "POLARIS"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.polaris)
        }else if(activeServiceMachine.machineBrand == "CANAM"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.brp)
        }else if(activeServiceMachine.machineBrand == "HARLEY"){
            layoutBinding.serviceBrandImage.setImageResource(R.drawable.harley)
        }

        // Set service machine info
        layoutBinding.serviceMachineName.text = "${activeServiceMachine.machineYear} ${activeServiceMachine.machineModel}"
        layoutBinding.serviceCustomerName.text = activeServiceMachine.customerName
        layoutBinding.serviceMachineColor.text = activeServiceMachine.machineColor
        layoutBinding.serviceMachineTime.text = activeServiceMachine.time

        // Active service machine remove button listener to remove the machine from the list
        layoutBinding.serviceRemoveMachine.setOnClickListener{
            removeActiveServiceMachine(activeServiceMachine)
        }

        // Set ready button according to machine ready status
        val readyButton = layoutBinding.serviceReadyButton
        if(activeServiceMachine.ready){
            layoutBinding.serviceReadyButton.setBackgroundColor(Color.GREEN)
            readyButton.text = "Ready"
        }else{
            layoutBinding.serviceReadyButton.setBackgroundColor(Color.RED)
            layoutBinding.serviceReadyButton.text = "Not Ready"
        }

        // Active service machine "Ready" button listener to mark the machine as ready
        readyButton.setOnClickListener {
            if(!activeServiceMachine.ready){
                layoutBinding.serviceReadyButton.setBackgroundColor(Color.GREEN)
                layoutBinding.serviceReadyButton.text = "Ready"
                toggleReadyActiveServiceMachine(activeServiceMachine)
            }else{
                layoutBinding.serviceReadyButton.setBackgroundColor(Color.RED)
                layoutBinding.serviceReadyButton.text = "Not Ready"
                toggleReadyActiveServiceMachine(activeServiceMachine)
            }
        }
    }
}