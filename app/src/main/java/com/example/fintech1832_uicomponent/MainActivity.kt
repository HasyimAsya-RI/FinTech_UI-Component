package com.example.fintech1832_uicomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fintech1832_uicomponent.home.HomeFragment
import com.example.fintech1832_uicomponent.profile.ProfileActivity
import com.example.fintech1832_uicomponent.setting.SettingActivity

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