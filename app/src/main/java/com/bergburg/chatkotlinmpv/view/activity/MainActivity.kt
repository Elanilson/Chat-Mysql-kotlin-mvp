package com.bergburg.chatkotlinmpv.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.databinding.ActivityMainBinding
import com.bergburg.chatkotlinmpv.view.fragments.ContatosFragment
import com.bergburg.chatkotlinmpv.view.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        configuracaoBottonNavigation()


    }

    private fun configuracaoBottonNavigation(){

        supportFragmentManager.beginTransaction().replace(R.id.bodyRelativeLayout,ContatosFragment()).commit()
        binding.bottomNavigation.selectedItemId = R.id.contatos
        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.contatos -> fragment = ContatosFragment()
                R.id.conversas -> fragment = ConversasFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.bodyRelativeLayout,fragment).commit()
            true
        }

    }


}