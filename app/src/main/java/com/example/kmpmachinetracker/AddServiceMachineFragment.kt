package com.example.kmpmachinetracker

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.kmpmachinetracker.databinding.FragmentAddServiceMachineBinding

/**
 * Clay Sandos - Karl Malone Powersports SLC
 * March 23, 2026
 *
 * AddServiceMachine fragment representing the menu to add a new active service machine to be prepared.
 */
class AddServiceMachineFragment : Fragment(R.layout.fragment_add_service_machine) {
    private val addServiceMachineFragmentBinding: FragmentAddServiceMachineBinding by lazy {
        FragmentAddServiceMachineBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Access to MainActivity navigation function
        val mainActivity = activity as? MainActivity

        // Inflate the layout for this fragment
        return addServiceMachineFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TYPE SPINNER
        val serviceTypeSpinner = addServiceMachineFragmentBinding.type
        val serviceTypeList = listOf("ATV", "UTV", "SNOWMOBILE", "STREETBIKE", "DIRTBIKE", "BOAT")
        serviceTypeSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, serviceTypeList)
        serviceTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                val serviceSubtypeSpinner = addServiceMachineFragmentBinding.subtype
                val serviceATVSubtypeList = listOf("SPORT, UTILITY")
                val serviceUTVSubtypeList = listOf("SPORT", "UTILITY")
                val serviceSnowmobileSubtypeList = listOf("SPORT", "UTILITY")
                val serviceStreetbikeSubtypeList = listOf("SPORT", "DUALSPORT", "TOURING", "CRUISER")
                val serviceDirtbikeSubtypeList = listOf("MX", "TRAIL")
                val serviceBoatSubtypeList = listOf("SITDOWN", "STANDUP")
                var subtypeList = listOf("")

                if(serviceTypeSpinner.selectedItem == "ATV"){
                    subtypeList = serviceATVSubtypeList
                }else if(serviceTypeSpinner.selectedItem == "UTV"){
                    subtypeList = serviceUTVSubtypeList
                }else if(serviceTypeSpinner.selectedItem == "SNOWMOBILE"){
                    subtypeList = serviceSnowmobileSubtypeList
                }else if(serviceTypeSpinner.selectedItem == "STREETBIKE"){
                    subtypeList = serviceStreetbikeSubtypeList
                }else if(serviceTypeSpinner.selectedItem == "DIRTBIKE"){
                    subtypeList = serviceDirtbikeSubtypeList
                }else if(serviceTypeSpinner.selectedItem == "BOAT"){
                    subtypeList = serviceBoatSubtypeList
                }

                serviceSubtypeSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, subtypeList)
                serviceSubtypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                        // BRAND SPINNER
                        val serviceBrandSpinner = addServiceMachineFragmentBinding.brand
                        val serviceDirtbikeBrandList = listOf("HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS", "DUCATI", "TRIUMPH")
                        val serviceStreetbikeBrandList = listOf("HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS", "DUCATI", "TRIUMPH", "BMW", "HARLEY", "INDIAN", "CFMOTO", "BRP")
                        val serviceATVBrandList = listOf("HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "CFMOTO", "ARCTIC CAT", "POLARIS", "BRP")
                        val serviceUTVBrandList = listOf("HONDA", "YAMAHA", "KAWASAKI", "POLARIS", "BRP", "CFMOTO", "ARCTIC CAT")
                        val serviceSnowmobileBrandList = listOf("YAMAHA", "POLARIS", "SKI DOO", "LYNX", "ARCTIC CAT")
                        val serviceBoatBrandList = listOf("HONDA", "YAMAHA", "KAWASAKI", "SEA DOO")
                        var brandList = listOf("")

                        if(serviceTypeSpinner.selectedItem == "ATV"){
                            brandList = serviceATVBrandList
                        }else if(serviceTypeSpinner.selectedItem == "UTV"){
                            brandList = serviceUTVBrandList
                        }else if(serviceTypeSpinner.selectedItem == "SNOWMOBILE"){
                            brandList = serviceSnowmobileBrandList
                        }else if(serviceTypeSpinner.selectedItem == "STREETBIKE"){
                            brandList = serviceStreetbikeBrandList
                        }else if(serviceTypeSpinner.selectedItem == "DIRTBIKE"){
                            brandList = serviceDirtbikeBrandList
                        }else if(serviceTypeSpinner.selectedItem == "BOAT"){
                            brandList = serviceBoatBrandList
                        }

                        serviceBrandSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, brandList)
                        serviceBrandSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                                // YEAR SPINNER
                                val serviceYearSpinner = addServiceMachineFragmentBinding.year
                                val yearList = listOf("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026")
                                serviceYearSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, yearList)
                                serviceYearSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                        val serviceModelSpinner = addServiceMachineFragmentBinding.year
                                        var modelList = listOf("")

                                        var service00to05HondaSportATVModelList = listOf("TRX90", "TRX300EX", "TRX400EX", "TRX450R")
                                        var service00to05HondaUtilityATVModelList = listOf("TRX250", "TRX300", "TRX350", "TRX400", "TRX450", "TRX500", "TRX650")
                                        var service00to05HondaSportUTVModelList = listOf("") // NONE
                                        var service00to05HondaUtilityUTVModelList = listOf("") // NONE
                                        var service00to05HondaSportSnowmobileModelList = listOf("") // NONE
                                        var service00to05HondaUtilitySnowmobileModelList = listOf("") // NONE
                                        var service00to05HondaSportStreetbikeModelList = listOf("")
                                        var service00to05HondaDualSportStreetbikeModelList = listOf("")
                                        var service00to05HondaTouringStreetbikeModelList = listOf("")
                                        var service00to05HondaCruiserStreetbikeModelList = listOf("")
                                        var service00to05HondaMXDirtbikeModelList = listOf("CR85", "CR125", "CRF250R", "CR250", "CRF450R", "CR500")
                                        var service00to05HondaTrailDirtbikeModelList = listOf("XR50", "XR70", "XR80", "XR100", "XR200", "XR250", "XR400", "CRF50", "CRF70", "CRF80", "CRF100", "CRF150F", "CRF230F", "CRF250X", "CRF450X")

                                        if(Integer.getInteger(serviceYearSpinner.selectedItem.toString())!! > 1999 && Integer.getInteger(serviceYearSpinner.selectedItem.toString())!! < 2006){

                                        }

                                        serviceModelSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, modelList)
                                        serviceModelSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                                            ) {
                                                // DO SOMETHING IF MODEL SELECTED
                                            }

                                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                                // DO NOTHING IF NO MODEL SELECTED
                                            }

                                        }
                                    }

                                    override fun onNothingSelected(p0: AdapterView<*>?) {
                                        // DO NOTHING IF NO YEAR SELECTED
                                    }
                                }
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                // DO NOTHING IF NO BRAND SELECTED
                            }
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        // DO NOTHING IF NO SUBTYPE SELECTED
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // DO NOTHING IF NO TYPE SELECTED
            }
        }
    }
}