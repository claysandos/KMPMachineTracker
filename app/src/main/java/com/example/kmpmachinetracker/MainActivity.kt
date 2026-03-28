package com.example.kmpmachinetracker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kmpmachinetracker.databinding.ActivityMainBinding

/**
 * Main activity representing the main screen of the app.
 * - Back Button: Navigate to last fragment that the user was on
 * - Home Button: Navigate to home navigation menu fragment
 */
class MainActivity : AppCompatActivity() {
    var lastFragmentTitle = "Machine Preparation Tracker"

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }

    // Active service machine data
    val activeServiceMachineViewModel: ActiveServiceMachineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initially navigate to home fragment
        navigateFragment(HomeFragment(), "Machine Preparation Tracker")

        val backButton = activityMainBinding.back
        backButton.setOnClickListener(){
            if(lastFragmentTitle == "Machine Preparation Tracker"){
                navigateFragment(HomeFragment(), "Machine Preparation Tracker")
            }else if(lastFragmentTitle == "Add Service Machine"){
                navigateFragment(AddServiceMachineFragment(), "Add Service Machine")
            }else if(lastFragmentTitle == "Add Sold Machine"){
                navigateFragment(AddSoldMachineFragment(), "Add Sold Machine")
            }else if(lastFragmentTitle == "Active Service Machines"){
                navigateFragment(ActiveServiceMachinesFragment(), "Active Service Machines")
            }else if(lastFragmentTitle == "Active Sold Machines"){
                navigateFragment(ActiveSoldMachinesFragment(), "Active Sold Machines")
            }
        }

        val homeButton = activityMainBinding.goHome
        homeButton.setOnClickListener{
            navigateFragment(HomeFragment(), "Machine Preparation Tracker")
        }

        // Inflate layout with inflated view binding
        setContentView(activityMainBinding.root)
    }

    /**
     * Function to set current fragment and update fragment title text
     */
    fun navigateFragment(fragment: Fragment, fragmentName: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FragmentView, fragment)
            commit()
        }
        lastFragmentTitle = activityMainBinding.fragmentTitle.text.toString()
        activityMainBinding.fragmentTitle.text = fragmentName
    }
}