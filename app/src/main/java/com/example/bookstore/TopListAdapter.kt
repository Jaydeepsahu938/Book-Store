package com.example.bookstore

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class TopListAdapter(private var topList: MutableList<Int>,private var context:Context):
    BaseAdapter() {
    override fun getCount(): Int {
        return topList.size
    }

    override fun getItem(p0: Int): Any {
             TODO()
    }

    override fun getItemId(p0: Int): Long =0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val imageView:ImageView
        if(convertView==null){
            imageView=ImageView(context)
            imageView.layoutParams=ViewGroup.LayoutParams(250,400)
            imageView.scaleType=ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8)
        }
        else{
            imageView=convertView as ImageView
        }
        imageView.setImageResource(topList[position])
        return imageView
    }

}