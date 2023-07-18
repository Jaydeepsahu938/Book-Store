@file:Suppress("DEPRECATION")

package com.example.bookstore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm){
    val PageNumber=3
    override fun getCount(): Int {
        return PageNumber
    }

    override fun getItem(position: Int): Fragment {
       return when(position){
           0->FragmentOne()
           1->FragmentTwo()
           2->FragmentThree()
           else->FragmentOne()
       }
    }

    override fun getPageTitle(position: Int): CharSequence{
        return when(position){
            0->"Top"
            1->"Children"
            2->"Friction"
            else->""
        }
    }
}