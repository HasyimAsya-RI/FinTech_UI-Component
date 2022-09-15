package com.example.fintech1832_uicomponent.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.fintech1832_uicomponent.R
import com.example.fintech1832_uicomponent.profile.ProfileActivity
import java.lang.StringBuilder

class SettingActivity : AppCompatActivity() {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView(R.layout.activity_setting)

        title = "Menu Pengaturan"
        val btnsimpan   = findViewById<Button>          (R.id.btsimpan)
        val nama        = findViewById<EditText>        (R.id.etnamalkp)
        val npm         = findViewById<EditText>        (R.id.etnpm)
        val email       = findViewById<EditText>        (R.id.etemail)
        val hp          = findViewById<EditText>        (R.id.ethp)
        val sandi       = findViewById<EditText>        (R.id.etsandi)
        val rgjk        = findViewById<RadioGroup>      (R.id.rgjk)
        val spiner      = findViewById<Spinner>         (R.id.spiner)
        val amcc        = findViewById<CheckBox>        (R.id.amcc)
        val himssi      = findViewById<CheckBox>        (R.id.himssi)
        val bem         = findViewById<CheckBox>        (R.id.bem)
        val togglebtn   = findViewById<ToggleButton>    (R.id.tooglebtn)

        btnsimpan.setOnClickListener {
            // Jenis Kelamin
            val cekjk   = rgjk.checkedRadioButtonId
            val jk      = findViewById<RadioButton>     ( cekjk )

            // Organisasi
            val org     = StringBuilder()
            if( amcc.isChecked ) {
                org.append("AMCC\n")
            }
            if( himssi.isChecked ) {
                org.append("HIMSSI\n")
            }
            if( bem.isChecked ) {
                org.append("BEM AMIKOM\n")
            }

            // Untuk menampung String yang akan dikirimkan ke ProfileActivity nantinya.
            val bundle = Bundle()
            bundle.putString( "nama",   nama.text.toString() )
            bundle.putString( "npm",    npm.text.toString() )
            bundle.putString( "email",  email.text.toString() )
            bundle.putString( "hp",     hp.text.toString() )
            bundle.putString( "jk",     "${ jk.text }" )
            bundle.putString( "prodi",  spiner.selectedItem.toString() )
            bundle.putString( "org",    org.toString() )
            bundle.putString( "status", togglebtn.text.toString() )

            // Pengkondisian
            if( !Patterns.EMAIL_ADDRESS.matcher( email.text.toString() ).matches() ) {
                email.error = "Masukkan email dengan benar!"
            }
            else if( sandi.length() == 0 ) {
                sandi.error = "Kata sandi tidak boleh kosong!"
            }
            else {
                val alertDialogBuilder = AlertDialog.Builder( this )
                alertDialogBuilder.setTitle( "PERINGATAN" )
                alertDialogBuilder.setMessage( "Apakah data Anda sudah benar?" )
                    .setCancelable( false )
                    .setPositiveButton( "Yes" ) {
                            dialogInterface, i ->
                                val intent = Intent( this, ProfileActivity::class.java )
                                intent.putExtras( bundle )
                                startActivity( intent )
                                Toast.makeText( this, "Data profil berhasil tersimpan.", Toast.LENGTH_SHORT ).show()
                    }
                    .setNegativeButton( "No" ) {
                            dialogInterface, i ->
                        dialogInterface.cancel()
                    }

                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }
}