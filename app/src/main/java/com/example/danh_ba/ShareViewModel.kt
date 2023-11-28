package com.example.danh_ba

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {
 var dataPhoneBook = MutableLiveData<MutableList<Person>>()

 fun getPhoneBookData(): MutableLiveData<MutableList<Person>> {
  return dataPhoneBook
 }

 fun setPhoneBook(persons: MutableList<Person>) {
  dataPhoneBook.value = persons
 }
}
