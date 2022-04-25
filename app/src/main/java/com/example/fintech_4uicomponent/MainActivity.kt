package com.example.fintech_4uicomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fintech_4uicomponent.home.HomeActivity
import com.example.fintech_4uicomponent.home.HomeFragment
import com.example.fintech_4uicomponent.profile.ProfileActivity
import com.example.fintech_4uicomponent.profile.ProfileFragment
import com.example.fintech_4uicomponent.setting.SettingActivity
import com.example.fintech_4uicomponent.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome: Button
    private lateinit var btnProfile: Button
    private lateinit var btnSetting: Button

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        btnHome     = findViewById( R.id.btn_home )
        btnProfile  = findViewById( R.id.btn_profile )
        btnSetting  = findViewById( R.id.btn_setting )

//        btnHome.setOnClickListener {
//            val intent = Intent( this, HomeActivity::class.java )
//            intent.putExtra( "username", "hasyim" )
//            startActivity( intent )
//        }

        btnHome.setOnClickListener {
            loadFragment( HomeFragment() )
        }
        btnProfile.setOnClickListener {
            val intent = Intent( this, ProfileActivity::class.java )
            startActivity( intent )
        }
        btnSetting.setOnClickListener {
            val intent = Intent( this, SettingActivity::class.java )
            startActivity( intent )
        }
    }

    private fun loadFragment( fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace( R.id.container, fragment )
            .commitNow()
    }
}