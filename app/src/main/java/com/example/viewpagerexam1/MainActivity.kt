package com.example.viewpagerexam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UCFragmentManager().changeFragment(FragMain())

    }

    inner class UCFragmentManager {
        val ft = supportFragmentManager.beginTransaction()
        fun changeFragment(fragment: Fragment) {

            ft.replace(R.id.fragment, fragment).commit()

        }
        fun setFragmentNumber(fragment: Int) {
            when (fragment) {
                1 -> MainView.screenNumber = 1
                2 -> MainView.screenNumber = 2
                3 -> MainView.screenNumber = 3
                else -> MainView.screenNumber = 0
            }
            UCFragmentManager().changeFragment(FragMain())
        }
    }

}
