package com.example.asj2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
//ADAPTER will bring the instance of interface
//adapter will get data from activity through net in its constructor
class Adapter(val items: ArrayList<Student>,val listener:ItemClicked) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //have to return a Holder but it is in xml file
        //layout inflater is used to convert xml into view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        val holder=Holder(view)
        //after view click whatever should be done is the responsibility of the activity
        // and not the adapter
        //so to tell the activity we need a callback from adapter
        // that will tell the activity that view is clicked
        //simple way to perform callback is to through interface
        //handle onclick
        view.setOnClickListener {
            //it will tell us the position of viewholder in the adapter
listener.onItemClicked(items[holder.adapterPosition])
        }
        return holder
    }

    //get called only one time ,tells us how many items would reside in the list
    override fun getItemCount(): Int {
        return items.size
    }

    //binds the data to the holder
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("Adapter ","inside bind")
        val current_item: Student = items[position]
        holder.name.text = "Name: "+current_item.name
        holder.roll.text="Roll: "+current_item.roll.toString()

    }

}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.txt_name)
    val roll: TextView = itemView.findViewById(R.id.txt_roll)

}
//onclick listener is an interface
interface ItemClicked{
    fun onItemClicked(item:Student)
}
