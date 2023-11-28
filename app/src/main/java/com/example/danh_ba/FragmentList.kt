package com.example.danh_ba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.ryc_list)

        val shareViewModel =(requireActivity() as MainActivity).dataUser()

        val adapter = Adapter( object : Adapter.ClickItem {
            override fun clickPerson(person: Person) {
                val action = FragmentListDirections.actionFragmentListToFragmentInfo(person)
                findNavController().navigate(action)
            }
        })
        val linnearManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linnearManager
        recyclerView.adapter = adapter
        shareViewModel.dataPhoneBook.observe(viewLifecycleOwner) { persons ->
            adapter.setData(persons)
        }
        return view
    }
}