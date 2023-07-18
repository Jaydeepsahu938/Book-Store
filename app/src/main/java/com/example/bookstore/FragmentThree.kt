package com.example.bookstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class FragmentThree : Fragment() {
   private var fictionList : MutableList<Int> = mutableListOf(
       R.drawable.fiction_one,
       R.drawable.fiction_two,
       R.drawable.fiction_three,
       R.drawable.fiction_four,
       R.drawable.fiction_five,
       R.drawable.fiction_six,
       R.drawable.fiction_seven,
       R.drawable.fiction_eight,
       R.drawable.fiction_nine,
       R.drawable.fiction_ten,
       R.drawable.fiction_one,
       R.drawable.fiction_two,
       R.drawable.fiction_three,
       R.drawable.fiction_four,
       R.drawable.fiction_five,
       R.drawable.fiction_six,
       R.drawable.fiction_seven,
       R.drawable.fiction_eight,
       R.drawable.fiction_nine,
       R.drawable.fiction_ten,
       R.drawable.fiction_one,
       R.drawable.fiction_two,
       R.drawable.fiction_three,
       R.drawable.fiction_four,
       R.drawable.fiction_five,
       R.drawable.fiction_six,
       R.drawable.fiction_seven,
       R.drawable.fiction_eight,
       R.drawable.fiction_nine,
       R.drawable.fiction_ten,
       R.drawable.fiction_one,
       R.drawable.fiction_two,
       R.drawable.fiction_three,
       R.drawable.fiction_four,
       R.drawable.fiction_five,
       R.drawable.fiction_six,
       R.drawable.fiction_seven,
       R.drawable.fiction_eight,
       R.drawable.fiction_nine,
       R.drawable.fiction_ten
   )

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var layout:StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_three, container, false)

        recyclerView=view.findViewById(R.id.recycler_view)
        adapter= RecyclerViewAdapter(fictionList)
        recyclerView.adapter=adapter
        layout=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=layout
        return view
    }


}