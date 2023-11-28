package com.example.danh_ba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var shareViewModel:ShareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shareViewModel = ViewModelProvider(this)[ShareViewModel::class.java]
        val thanh = Person("1", "Nguyễn Văn Thành", "0123456789", "Thanhnguyen6702@gmail.com")
        val vang = Person("2", "Nguyễn Xuân Vang", "0123456789", "Thanhnguyen6702@gmail.com")
        val huy = Person("3", "Nguyễn Quang Huy", "0123456789", "Thanhnguyen6702@gmail.com")
        val manh = Person("4", "Vũ Tiến Mạnh", "0123456789", "Thanhnguyen6702@gmail.com")
        val dat = Person("5", "Nguyễn Văn Đạt", "0123456789", "Thanhnguyen6702@gmail.com")
        val hieu = Person("6", "Nguyễn Trung Hiếu", "0123456789", "Thanhnguyen6702@gmail.com")
        val listPerson = mutableListOf(thanh, vang, huy, manh, dat, hieu)
        shareViewModel.setPhoneBook(listPerson)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add ->{
                navController = Navigation.findNavController(this,R.id.fragmentContainerView)
                navController.navigate(R.id.activity_to_adduser)
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }
    }
    fun dataUser(): ShareViewModel{
        return shareViewModel
    }
}
