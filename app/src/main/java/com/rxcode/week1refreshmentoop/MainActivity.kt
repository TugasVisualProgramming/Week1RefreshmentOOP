package com.rxcode.week1refreshmentoop

import Adapter.ListDataRVAdapter
import Database.GlobalVar
import Interface.CardListener
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.rxcode.week1refreshmentoop.databinding.ActivityMainBinding
import com.rxcode.week1refreshmentoop.databinding.CardHewanBinding

class MainActivity : AppCompatActivity() , CardListener{

    private lateinit var viewBind: ActivityMainBinding
    private lateinit var viewBind1: CardHewanBinding
    private var position=-1

//    private val listDataHewan = ArrayList<Hewan>()
    private val adapter = ListDataRVAdapter(GlobalVar.listDataHewan,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        Listener()
        setupRecyclerView()
//        addDummyData()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(baseContext) //untuk mengatur recyleview mau baris atau kolom
        viewBind.listDataRV.layoutManager = layoutManager //set layout
        viewBind.listDataRV.adapter = adapter //set adapter
        if(GlobalVar.listDataHewan.isNotEmpty()){
            viewBind.pesanHewan.isInvisible = true
        }

    }

    private fun Listener(){
        viewBind.addDataFAB.setOnClickListener{
            val myIntent = Intent(this, AddAnimalActivity::class.java)
            startActivity(myIntent)
            finish()
        }
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }







//    private fun addDummyData(){
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//        listDataHewan.add(Hewan("joko","anjing","19"))
//    }

}