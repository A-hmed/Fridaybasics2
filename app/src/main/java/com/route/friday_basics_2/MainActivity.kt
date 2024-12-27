package com.route.friday_basics_2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.friday_basics_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(ChatFragment())
        binding.chatTab.setOnClickListener {
            showFragment(ChatFragment())
        }
        binding.callsTab.setOnClickListener {
            showFragment(CallsFragment())
        }
        binding.statusTab.setOnClickListener {
            showFragment(StatusFragment())
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}