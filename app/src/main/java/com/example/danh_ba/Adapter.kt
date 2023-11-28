package com.example.danh_ba;

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter( val clickItem: ClickItem): RecyclerView.Adapter<Adapter.ViewHoder_Person>() {
    private var list_person: MutableList<Person> = mutableListOf()
    interface ClickItem{
        fun clickPerson(person: Person)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(list_person: MutableList<Person>){
        this.list_person = list_person
        notifyDataSetChanged()
    }
    inner class ViewHoder_Person(val view:View): RecyclerView.ViewHolder(view){
        val logo = view.findViewById<TextView>(R.id.logo)
        val name = view.findViewById<TextView>(R.id.name_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder_Person {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info,parent,false)
        return ViewHoder_Person(view)
    }

    override fun getItemCount(): Int {
        return  list_person.size
    }

    override fun onBindViewHolder(holder: ViewHoder_Person, position: Int) {
            val name = list_person.get(position).Name.split(" ").lastOrNull()
            holder.logo.text = name?.get(0)?.uppercase() ?: "N"
            holder.name.text = list_person.get(position).Name
            holder.view.setOnClickListener{
                clickItem.clickPerson(list_person.get(position))
            }
    }
}
