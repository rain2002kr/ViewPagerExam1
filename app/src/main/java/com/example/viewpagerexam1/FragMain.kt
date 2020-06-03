package com.example.viewpagerexam1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragmain.*

class FragMain : Fragment() {
    val listName = mutableListOf<String>(
        "main","frag1","frag2","frag3"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragmain , container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val scrNum = MainView.screenNumber
        init(scrNum)
        val uc = UC()
        val TAG = "FragMain"

        //TODO 페이지의 스크롤을 안먹게 만드는 코드
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) { }
            override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) { }
            override fun onPageSelected(position: Int) {
                Log.d(TAG,"페이지번호${pager.currentItem}")
                val page = pager.currentItem
                if(page == 0 ){
                    uc.pagerDisable(true)
                } else {
                    uc.pagerDisable(false)
                }
            }
        })
    }

    fun init(startFragment :Int) {
        pager.setOffscreenPageLimit(10)
        val adapter = Pager1Adapter((activity as MainActivity).supportFragmentManager, listName)

        //TODO 추가 메뉴 구성해야함. 어뎁터에 프래그 담기
        val listFrag = listOf<Fragment>(
            Fragmenu(),Frag1(),Frag2(),Frag3()
        )
        //TODO Pager 어뎁터에 담을 프래그먼트 추가
        listFrag.forEach {
            adapter.addItem(it)
        }

        //TODO 탭 레이아웃 설정
        tab_layout.setupWithViewPager(pager)
        pager.adapter = adapter

        //TODO 뷰페이저 시작 페이지 설정
        pager.setCurrentItem(startFragment)

        //TODO 초기화면 체크
        val value = MainView.screenNumber
        if(value == 0 ){
            val uc = UC()
            uc.pagerDisable(true)
        }
    }
    inner class UC {
        fun pagerDisable(sw : Boolean){
            if(sw){
                pager.setOnTouchListener(object : View.OnTouchListener {
                    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                        return true
                    }
                })
                tab_layout.setVisibility(View.INVISIBLE)
            }
            else {
                pager.setOnTouchListener(object : View.OnTouchListener {
                    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                        return false
                    }
                })
                tab_layout.setVisibility(View.VISIBLE)
            }
        }
    }
}