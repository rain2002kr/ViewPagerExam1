package com.example.viewpagerexam1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class Pager1Adapter(fm: FragmentManager,val nameList: MutableList<String>) : FragmentStatePagerAdapter(fm) {
    val items = arrayListOf<Fragment>()

    fun addItem(item: Fragment){
        items.add(item)
    }

    override fun getItem(position: Int): Fragment {
        return items.get(position)
    }
    //페이지 수를 결정 (고정으로 줄수도 있음)
    override fun getCount(): Int {
        return items.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "${nameList[position]}" //+ position
    }

}