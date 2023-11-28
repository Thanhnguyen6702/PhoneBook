package com.example.danh_ba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class AddUser : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.adduser,container,false)
        val name = view.findViewById<EditText>(R.id.name_add)
        val sdt =  view.findViewById<EditText>(R.id.sdt_add)
        val gmail = view.findViewById<EditText>(R.id.gmail_add)
        val id = view.findViewById<EditText>(R.id.id_add)
        val button = view.findViewById<Button>(R.id.bt_add)
        val shareViewModel = (requireActivity() as MainActivity).dataUser()
        button.setOnClickListener {
            if (name.text.isBlank() || sdt.text.isBlank() || gmail.text.isBlank() || id.text.isBlank()) {
                    Toast.makeText(requireContext(),"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show()
            }
            else{
                val person = Person(id.text.toString(),name.text.toString(),sdt.text.toString(),gmail.text.toString())
                var listPerson = shareViewModel.getPhoneBookData().value
                if (listPerson != null) {
                    listPerson.add(person)
                    shareViewModel.setPhoneBook(listPerson)
                    val nav = Navigation.findNavController(view)
                    nav.navigate(R.id.action_addUser_to_fragmentList)
                }
            }
        }

        return view
    }
}