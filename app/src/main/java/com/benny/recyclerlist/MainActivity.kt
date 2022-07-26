package com.benny.recyclerlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.bloco.faker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val faker = Faker()
        val peopleList = arrayListOf<Person>()//Storing data of type Person

        for (i in 1..50) {
            val name = faker.name.firstName() + " " + faker.name.lastName()
            val email = faker.internet.email(name)
            val address = faker.address.streetAddress()
            val age = faker.number.between(18, 80)
            val phone = faker.phoneNumber.phoneNumber()

            //Log.d("FAKER", "$name : $email : $address : $age :  $phone")
            val person = Person(name, email, address, age, phone)//Storing data
            peopleList.add(person)
        }

        /*peopleList.forEach {
            Log.d("PEOPLE", it.name)
        }*/

        val recyclerPeople: RecyclerView = findViewById(R.id.recyclerViewPeople)
        recyclerPeople.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(peopleList)

        recyclerPeople.adapter = adapter


    }
}