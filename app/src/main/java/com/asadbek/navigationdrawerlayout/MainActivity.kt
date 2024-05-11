package com.asadbek.navigationdrawerlayout

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asadbek.navigationdrawerlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list:ArrayList<MyUser>
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        loadUsers()

        setSupportActionBar(binding.appBarMain.toolbar)
        binding.appBarMain.menuImage.setOnClickListener {
            Toast.makeText(this, "Image", Toast.LENGTH_SHORT).show()
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }
        myAdapter = MyAdapter(this,list)
        binding.rv.adapter = myAdapter


    }

    private fun loadUsers() {
        list.add(MyUser("Dominic","Android dasturlash..."))
        list.add(MyUser("Bobur","Qalaysiz?"))
        list.add(MyUser("Umar","Yetib keldim"))
        list.add(MyUser("Sherzod","Qayerdasan?"))
        list.add(MyUser("Ustoz","Vazifalarni qilib qo`ying"))
    }
}