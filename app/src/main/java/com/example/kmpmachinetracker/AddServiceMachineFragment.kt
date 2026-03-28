package com.example.kmpmachinetracker

import android.content.Context
import android.os.Bundle
import android.util.Log
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
    // Variables for adding the service machine
    private var brand = ""
    private var year = ""
    private var model = ""
    private var customer = ""
    private var color = ""
    private var time = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Access to MainActivity navigation function
        val mainActivity = activity as? MainActivity

        // Get inflated fragment view binding
        val addServiceMachineFragmentBinding = FragmentAddServiceMachineBinding.inflate(inflater, container, false)

        /** TYPE SPINNER **/
        val serviceTypeSpinner = addServiceMachineFragmentBinding.type
        val serviceTypeList = listOf("Choose a type...", "ATV", "UTV", "SNOWMOBILE", "STREETBIKE", "DIRTBIKE", "BOAT")
        serviceTypeSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, serviceTypeList)
        serviceTypeSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                /** SUBTYPE SPINNER **/
                var subtypeList = listOf("")
                val serviceSubtypeSpinner = addServiceMachineFragmentBinding.subtype
                val serviceATVSubtypeList = listOf("Now choose a subtype...", "SPORT", "UTILITY")
                val serviceUTVSubtypeList = listOf("Now choose a subtype...", "SPORT", "UTILITY")
                val serviceSnowmobileSubtypeList = listOf("Now choose a subtype...", "SPORT", "UTILITY")
                val serviceStreetbikeSubtypeList = listOf("Now choose a subtype...", "SPORT", "DUALSPORT", "TOURING", "CRUISER")
                val serviceDirtbikeSubtypeList = listOf("Now choose a subtype...", "MX", "TRAIL")
                val serviceBoatSubtypeList = listOf("Now choose a subtype...", "SITDOWN", "STANDUP")

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
                        /** BRAND SPINNER **/
                        var brandList = listOf("")
                        val serviceBrandSpinner = addServiceMachineFragmentBinding.brand

                        val serviceDirtbikeMXBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS")
                        val serviceDirtbikeTrailBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS")

                        val serviceStreetbikeSportBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS", "CFMOTO")
                        val serviceStreetbikeDualsportBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "HUSQVARNA", "GASGAS", "CFMOTO")
                        val serviceStreetbikeCruiserBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "HARLEY")
                        val serviceStreetbikeTouringBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "HARLEY")

                        val serviceATVSportBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "KTM", "CFMOTO", "POLARIS", "CANAM")
                        val serviceATVUtilityBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SUZUKI", "CFMOTO", "POLARIS", "CANAM")

                        val serviceUTVSportBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "POLARIS", "CANAM", "CFMOTO")
                        val serviceUTVUtilityBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "POLARIS", "CANAM", "CFMOTO")

                        val serviceSnowmobileSportBrandList = listOf("Now choose a brand...", "YAMAHA", "POLARIS", "SKI DOO", "LYNX")
                        val serviceSnowmobileUtilityBrandList = listOf("Now choose a brand...", "YAMAHA", "POLARIS", "SKI DOO", "LYNX")

                        val serviceBoatStandupBrandList = listOf("Now choose a brand...", "YAMAHA", "KAWASAKI")
                        val serviceBoatSitdownBrandList = listOf("Now choose a brand...", "HONDA", "YAMAHA", "KAWASAKI", "SEA DOO")

                        if(serviceTypeSpinner.selectedItem == "ATV"){
                            if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                brandList = serviceATVSportBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "UTILITY"){
                                brandList = serviceATVUtilityBrandList
                            }
                        }else if(serviceTypeSpinner.selectedItem == "UTV"){
                            if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                brandList = serviceUTVSportBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "UTILITY"){
                                brandList = serviceUTVUtilityBrandList
                            }
                        }else if(serviceTypeSpinner.selectedItem == "SNOWMOBILE"){
                            if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                brandList = serviceSnowmobileSportBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "UTILITY"){
                                brandList = serviceSnowmobileUtilityBrandList
                            }
                        }else if(serviceTypeSpinner.selectedItem == "STREETBIKE"){
                            if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                brandList = serviceStreetbikeSportBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "DUALSPORT"){
                                brandList = serviceStreetbikeDualsportBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "CRUISER"){
                                brandList = serviceStreetbikeCruiserBrandList
                            }else{
                                brandList = serviceStreetbikeTouringBrandList
                            }
                        }else if(serviceTypeSpinner.selectedItem == "DIRTBIKE"){
                            if(serviceSubtypeSpinner.selectedItem == "MX"){
                                brandList = serviceDirtbikeMXBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "TRAIL"){
                                brandList = serviceDirtbikeTrailBrandList
                            }
                        }else if(serviceTypeSpinner.selectedItem == "BOAT"){
                            if(serviceSubtypeSpinner.selectedItem == "STANDUP"){
                                brandList = serviceBoatStandupBrandList
                            }else if(serviceSubtypeSpinner.selectedItem == "SITDOWN"){
                                brandList = serviceBoatSitdownBrandList
                            }
                        }

                        serviceBrandSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, brandList)
                        serviceBrandSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                                brand = serviceBrandSpinner.selectedItem.toString()
                                /** YEAR SPINNER **/
                                val yearList = listOf(2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025)
                                val serviceYearSpinner = addServiceMachineFragmentBinding.year
                                serviceYearSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, yearList)
                                serviceYearSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                        year = serviceYearSpinner.selectedItem.toString()
                                        /** MODEL SPINNER **/
                                        var modelList = listOf("")
                                        val serviceModelSpinner = addServiceMachineFragmentBinding.model
                                        // HONDA - 2000 to 2005 - ATV, Streetbike, Dirtbike, Boat
                                        var service00to05HondaSportATVModelList = listOf("TRX90", "TRX300EX", "TRX400EX", "TRX450R")
                                        var service00to05HondaUtilityATVModelList = listOf("TRX250", "TRX300", "TRX350", "TRX400", "TRX450", "TRX500", "TRX650")
                                        var service00to05HondaSportStreetbikeModelList = listOf("CBR600F4", "CBR600F4i", "CBR600RR", "VFR800", "CBR929RR", "CBR954RR", "CBR1000RR", "CBR1100", "VTR1000", "RVT1000")
                                        var service00to05HondaDualSportStreetbikeModelList = listOf("XR650")
                                        var service00to05HondaTouringStreetbikeModelList = listOf("ST1100", "ST1300", "GOLDWING 1500", "GOLDWING 1800")
                                        var service00to05HondaCruiserStreetbikeModelList = listOf("REBEL 250", "SHADOW 600", "SHADOW 750", "MAGNA 750", "NIGHTHAWK 750", "SHADOW 1100", "VTX1300", "VALKYRIE 1500", "VTX1800")
                                        var service00to05HondaMXDirtbikeModelList = listOf("CR85", "CR125", "CRF250R", "CR250", "CRF450R", "CR500")
                                        var service00to05HondaTrailDirtbikeModelList = listOf("XR50", "XR70", "XR80", "XR100", "XR200", "XR250", "XR400", "CRF50", "CRF70", "CRF80", "CRF100", "CRF150F", "CRF230F", "CRF250X", "CRF450X")
                                        var service00to05HondaSitdownBoatModelList = listOf("F12", "F12X", "R12", "R12X")

                                        // HONDA - 2005 to 2010 - ATV, Streetbike, Dirtbike, Boat
                                        // TODO
                                        var service06to10HondaSportATVModelList = listOf("TRX90", "TRX300EX", "TRX400EX", "TRX450R")
                                        var service06to10HondaUtilityATVModelList = listOf("TRX250", "TRX300", "TRX350", "TRX400", "TRX450", "TRX500", "TRX650")
                                        var service06to10HondaSportStreetbikeModelList = listOf("CBR600F4", "CBR600F4i", "CBR600RR", "VFR800", "CBR929RR", "CBR954RR", "CBR1000RR", "CBR1100", "VTR1000", "RVT1000")
                                        var service06to10HondaDualSportStreetbikeModelList = listOf("XR650")
                                        var service06to10HondaTouringStreetbikeModelList = listOf("ST1100", "ST1300", "GOLDWING 1500", "GOLDWING 1800")
                                        var service06to10HondaCruiserStreetbikeModelList = listOf("REBEL 250", "SHADOW 600", "SHADOW 750", "MAGNA 750", "NIGHTHAWK 750", "SHADOW 1100", "VTX1300", "VALKYRIE 1500", "VTX1800")
                                        var service06to10HondaMXDirtbikeModelList = listOf("CR85", "CR125", "CRF250R", "CR250", "CRF450R", "CR500")
                                        var service06to10HondaTrailDirtbikeModelList = listOf("XR50", "XR70", "XR80", "XR100", "XR200", "XR250", "XR400", "CRF50", "CRF70", "CRF80", "CRF100", "CRF150F", "CRF230F", "CRF250X", "CRF450X")
                                        var service06to10HondaSitdownBoatModelList = listOf("F12", "F12X", "R12", "R12X", "F15", "F15X")

                                        // YAMAHA made ATVs, SNOWMOBILES, STREETBIKES, DIRTBIKES, and Boats from 2000 to 2005

                                        // KAWASAKI made ATVs, STREETBIKES, DIRTBIKES, and Boats from 2000 to 2005

                                        // SUZUKI made ATVs, STREETBIKES, and DIRTBIKES from 2000 to 2005

                                        // KTM made ATVs, STREETBIKES, and DIRTBIKES from 2000 to 2005

                                        // HUSQVARNA made machines from 2000 to 2005, but we cannot get parts for them (too old)

                                        // GASGAS made machines from 2000 to 2005, but we cannot get parts for them (too old)

                                        if(serviceYearSpinner.selectedItem in 2000..2005){
                                            if(serviceBrandSpinner.selectedItem == "HONDA"){
                                                if(serviceTypeSpinner.selectedItem == "ATV"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                                        modelList = service00to05HondaSportATVModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "UTILITY"){
                                                        modelList = service00to05HondaUtilityATVModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "STREETBIKE"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                                        modelList = service00to05HondaSportStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "DUALSPORT"){
                                                        modelList = service00to05HondaDualSportStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "CRUISER"){
                                                        modelList = service00to05HondaCruiserStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "TOURING"){
                                                        modelList = service00to05HondaTouringStreetbikeModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "DIRTBIKE"){
                                                    if(serviceSubtypeSpinner.selectedItem == "MX"){
                                                        modelList = service00to05HondaMXDirtbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "TRAIL"){
                                                        modelList = service00to05HondaTrailDirtbikeModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "BOAT"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SITDOWN"){
                                                        modelList = service00to05HondaSitdownBoatModelList
                                                    }
                                                }
                                            }
                                        }else if(serviceYearSpinner.selectedItem in 2006..2010){
                                            if(serviceBrandSpinner.selectedItem == "HONDA"){
                                                if(serviceTypeSpinner.selectedItem == "ATV"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                                        modelList = service06to10HondaSportATVModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "UTILITY"){
                                                        modelList = service06to10HondaUtilityATVModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "STREETBIKE"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SPORT"){
                                                        modelList = service06to10HondaSportStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "DUALSPORT"){
                                                        modelList = service06to10HondaDualSportStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "CRUISER"){
                                                        modelList = service06to10HondaCruiserStreetbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "TOURING"){
                                                        modelList = service06to10HondaTouringStreetbikeModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "DIRTBIKE"){
                                                    if(serviceSubtypeSpinner.selectedItem == "MX"){
                                                        modelList = service06to10HondaMXDirtbikeModelList
                                                    }else if(serviceSubtypeSpinner.selectedItem == "TRAIL"){
                                                        modelList = service06to10HondaTrailDirtbikeModelList
                                                    }
                                                }else if(serviceTypeSpinner.selectedItem == "BOAT"){
                                                    if(serviceSubtypeSpinner.selectedItem == "SITDOWN"){
                                                        modelList = service06to10HondaSitdownBoatModelList
                                                    }
                                                }
                                            }
                                        }else if(serviceYearSpinner.selectedItem in 2011..2015){
                                            // TODO
                                        }else if(serviceYearSpinner.selectedItem in 2016..2020){
                                            // TODO
                                        }else if(serviceYearSpinner.selectedItem in 2021..2025){
                                            // TODO
                                        }

                                        serviceModelSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, modelList)
                                        serviceModelSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                                model = serviceModelSpinner.selectedItem.toString()

                                                /** COLOR SPINNER **/
                                                var colorList = listOf("")
                                                if(serviceModelSpinner.selectedItem != "Now choose a model..."){
                                                    colorList = listOf("BLACK", "GRAY", "WHITE", "PINK", "RED", "ORANGE", "YELLOW", "GREEN", "CYAN", "BLUE", "PURPLE")
                                                }
                                                val serviceColorSpinner = addServiceMachineFragmentBinding.color
                                                serviceColorSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, colorList)
                                                serviceColorSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                                        color = serviceColorSpinner.selectedItem.toString()
                                                    }

                                                    override fun onNothingSelected(p0: AdapterView<*>?) {
                                                        // DO NOTHING IF NO COLOR SELECTED
                                                    }

                                                }
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

        addServiceMachineFragmentBinding.serviceAddMachineButton.setOnClickListener{
            customer = addServiceMachineFragmentBinding.customer.text.toString()
            time = addServiceMachineFragmentBinding.time.text.toString()
            mainActivity?.activeServiceMachineViewModel?.addActiveServiceMachine(brand, year, model, customer, color, false, time)
            mainActivity?.navigateFragment(ActiveServiceMachinesFragment(), "Active Service Machines")
        }

        // Inflate the layout for this fragment
        return addServiceMachineFragmentBinding.root
    }
}
