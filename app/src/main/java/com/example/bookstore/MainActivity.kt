package com.example.bookstore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.bookstore.Profile.Companion.FIRST_NAME
import com.example.bookstore.Profile.Companion.LAST_NAME
import com.example.bookstore.Profile.Companion.SHAREDPrefs
import com.example.bookstore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val mBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    private lateinit var viewPager:ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var drawerlayout:DrawerLayout
    private lateinit var full_name:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        drawerlayout=findViewById(R.id.drawer_layout)

        setSupportActionBar(findViewById(R.id.toolbar))
        val actionBar:ActionBar? =supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        val navigationView:NavigationView=findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener {
           menuItem->
            when(menuItem.itemId){
                R.id.profile->{
                    val intent=Intent(this,Profile::class.java)
                    startActivity(intent)
                }
                R.id.about->{
                        val intent=Intent(this,AboutActivity::class.java)
                    startActivity(intent)
                    }
            }
            drawerlayout.closeDrawers()
            true
        }
        viewPager=mBinding.viewPager
        tabLayout=mBinding.tabLayout

        val pagerAdapter=MyPagerAdapter(supportFragmentManager)
        viewPager.adapter=pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            android.R.id.home->{
                val sharedPrefs=this.getSharedPreferences(SHAREDPrefs,Context.MODE_PRIVATE)
                val firstName:String?=sharedPrefs.getString(FIRST_NAME,"name")
                val lastName:String?=sharedPrefs.getString(LAST_NAME,"lastname")
                 val space:String=" "
                full_name=findViewById(R.id.full_name)
                full_name.text="$firstName$space$lastName"
                drawerlayout.openDrawer(GravityCompat.START)
                true
            }
            else->return super.onOptionsItemSelected(item)
        }

    }
}