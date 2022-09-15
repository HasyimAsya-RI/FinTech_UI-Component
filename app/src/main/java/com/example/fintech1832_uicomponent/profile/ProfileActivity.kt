package com.example.fintech1832_uicomponent.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.fintech1832_uicomponent.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView(R.layout.activity_profile)

        // Membuka (menerima) bundle dari SettingActivity yang akan ditampilkan pada UI ProfileActivity.
        title = "Menu Profile"
        val nama    = findViewById<TextView>    (R.id.tvnama)
        val npm     = findViewById<TextView>    (R.id.tvnpm)
        val email   = findViewById<TextView>    (R.id.tvemail)
        val hp      = findViewById<TextView>    (R.id.tvhp)
        val jk      = findViewById<TextView>    (R.id.tvjk)
        val prodi   = findViewById<TextView>    (R.id.tvprodi)
        val org     = findViewById<TextView>    (R.id.tvorg)
        val status  = findViewById<TextView>    (R.id.tvstatus)

        val bukabundle = intent.extras
        if( bukabundle != null ) {
            nama.setText    ( bukabundle.getString( "nama" ) )
            npm.setText     ( bukabundle.getString( "npm" ) )
            email.setText   ( bukabundle.getString( "email" ) )
            hp.setText      ( bukabundle.getString( "hp" ) )
            jk.setText      ( bukabundle.getString( "jk" ) )
            prodi.setText   ( bukabundle.getString( "prodi" ) )
            org.setText     ( bukabundle.getString( "org" ) )
            status.setText  ( bukabundle.getString( "status" ) )
        }
    }
}