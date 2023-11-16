package com.example.danh_ba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentList: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.ryc_list)
        val thanh =  Person("1","Nguyễn Văn Thành","0123456789","Thanhnguyen6702@gmail.com")
        val vang = Person("2","Nguyễn Xuân Vang","0123456789","Thanhnguyen6702@gmail.com")
        val huy = Person("3","Nguyễn Quang Huy","0123456789","Thanhnguyen6702@gmail.com")
        val manh = Person("4","Vũ Tiến Mạnh","0123456789","Thanhnguyen6702@gmail.com")
        val dat = Person("5","Nguyễn Văn Đạt","0123456789","Thanhnguyen6702@gmail.com")
        val hieu = Person("6","Nguyễn Trung Hiếu","0123456789","Thanhnguyen6702@gmail.com")
        val listPerson = mutableListOf(thanh,vang,huy,manh,dat,hieu)
        val adapter = Adapter(listPerson,object :Adapter.ClickItem{
            override fun clickPerson(person: Person) {
                val action = FragmentListDirections.actionFragmentListToFragmentInfo(person)
                findNavController().navigate(action)
            }

        })
        val linnearManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linnearManager
        recyclerView.adapter = adapter
        return view
    }
}