package com.example.viewpagerexam1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag1.*

class Frag1 :Fragment(){

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag1,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val manager = (activity as MainActivity).UCFragmentManager()
        bt_fragss2.setOnClickListener{
            manager.setFragmentNumber(2)
        }
        bt_fragss3.setOnClickListener{
            manager.setFragmentNumber(3)
        }

    }

}