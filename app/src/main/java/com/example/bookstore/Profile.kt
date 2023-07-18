package com.example.bookstore

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import de.hdodenhof.circleimageview.CircleImageView
import java.io.IOException

@Suppress("DEPRECATION")
class Profile : AppCompatActivity() {

    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var profileImageView: CircleImageView
    private lateinit var savebtn:Button
    private lateinit var first_name:EditText
    private lateinit var last_name:EditText
    companion object{
        const val  SHAREDPrefs="mysharedprefs"
        const val FIRST_NAME="firstname"
        const val LAST_NAME="last_name"
        private const val SELECT_IMAGE=1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPrefs=this.getSharedPreferences(SHAREDPrefs,Context.MODE_PRIVATE)?:return
        profileImageView=findViewById(R.id.profile_imageview)
        savebtn=findViewById(R.id.save_button)
        first_name=findViewById(R.id.first_name)
        last_name=findViewById(R.id.last_name)

        setSupportActionBar(findViewById(R.id.included))

        val actionBar : ActionBar? =supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        profileImageView.setOnClickListener {
            val intent= Intent()
            intent.type="image/*"
            intent.action=Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_IMAGE)
        }

        savebtn.setOnClickListener{
           with(sharedPrefs.edit()){
               putString(FIRST_NAME,first_name.text.toString())
               putString(LAST_NAME,last_name.text.toString())
               apply()
           }
        }
    }



    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode== SELECT_IMAGE)
            if(resultCode==Activity.RESULT_OK){
                if(data!=null)
                {
                    try{
                    val selectedImage:Uri?=data.data
                    val yourSelectedImage:Bitmap=BitmapFactory.decodeStream(contentResolver.openInputStream(selectedImage!!))
                    profileImageView.setImageBitmap(yourSelectedImage)}
                    catch (e:IOException){
                        Log.e("Profile","The Image Is Not Loaded:$e")
                    }
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}