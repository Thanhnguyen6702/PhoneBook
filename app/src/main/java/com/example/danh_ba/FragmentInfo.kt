package com.example.danh_ba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class FragmentInfo: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.info_personal,container,false)

        val args: FragmentListArgs by navArgs()
        val person: Person = args.info
        if (person != null) {
            val id = view.findViewById<TextView>(R.id.id_info)
            val name = view.findViewById<TextView>(R.id.name)
            val sdt = view.findViewById<TextView>(R.id.sdt)
            val gmail = view.findViewById<TextView>(R.id.gmail)
            id.text = person.ID
            name.text = person.Name
            sdt.text = person.SDT
            gmail.text = person.Email

        }
        return view
    }
}