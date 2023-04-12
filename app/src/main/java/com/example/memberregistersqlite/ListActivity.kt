package com.example.memberregistersqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memberregistersqlite.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding:ActivityListBinding
    lateinit var dbHelper:DBHelper
    var memberData : MutableList<Member> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var dbHelper = DBHelper(applicationContext, MainActivity.DB_NAME, MainActivity.VERSION)


        memberData = dbHelper.selectAll()!!
        binding.recyclerView.adapter = RecyclerAdapter(memberData)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}