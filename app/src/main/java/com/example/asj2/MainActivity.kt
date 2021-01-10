package com.example.asj2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recycler view needs a layout manager and an adapter
        //recycler_view.layoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        //recycler_view.layoutManager=GridLayoutManager(this,2)
        recycler_view.layoutManager=LinearLayoutManager(this)
        //can use grid view as well as staggered asa well
        //build an adapter
        //declaring with :
        val data=getData()
        //currently activity is a listener
        val adapter:Adapter= Adapter(data,this)
        recycler_view.adapter=adapter

    }
    private fun getData():ArrayList<Student>{
        //initialising with =
        //val list1=ArrayList<String>()
        val list=ArrayList<Student>()
        for(i in 0 until 20){
            list.add(Student((65+i).toChar().toString(),i+1))

        }
        return list
    }
//implement the inteface
    //do whatever u want when itemclick
    override fun onItemClicked(item: Student) {
       Toast.makeText(this,"Item clicked "+item.name,Toast.LENGTH_SHORT).show()
    val intent= Intent(this,DetailsActivity::class.java)
    intent.putExtra("name",item.name)
    intent.putExtra("roll",item.roll)
    startActivity(intent)

    }
}