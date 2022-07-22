package com.benny.recyclerlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.bloco.faker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val faker = Faker()


        for (i in 1..10) {
            val name = faker.name.firstName() + " " + faker.name.lastName()
            val email = faker.internet.email()
            val address = faker.address.streetAddress()
            val age = faker.number.between(18, 80)
            val phone = faker.phoneNumber.phoneNumber()

            Log.d("FAKER", "$name : $email : $address : $age :  $phone")

        }
    }
}