package com.xaijea.wafflestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {


    private lateinit var flavourRadioGroup: RadioGroup
    private lateinit var sizeRadioGroup: RadioGroup
    private lateinit var sprinklesCheckbox: CheckBox
    private lateinit var chocolatebitsCheckbox: CheckBox
    private lateinit var nipsCheckbox: CheckBox
    private lateinit var oreocookiesCheckbox: CheckBox
    private lateinit var stickoCheckbox: CheckBox
    private lateinit var marshmallowCheckbox: CheckBox

    private lateinit var calculateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sprinklesCheckbox = findViewById(R.id.sprinkles)
        chocolatebitsCheckbox = findViewById(R.id.chocolate_bits)
        nipsCheckbox = findViewById(R.id.nips)
        oreocookiesCheckbox = findViewById(R.id.oreo_cookies)
        stickoCheckbox = findViewById(R.id.sticko)
        marshmallowCheckbox = findViewById(R.id.marshmallow)
        flavourRadioGroup = findViewById(R.id.flavourRadioGroup)
        sizeRadioGroup = findViewById(R.id.sizeRadioGroup)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {

            val selectedToppings = mutableListOf<String>()
            val selectedFlavourId = flavourRadioGroup.checkedRadioButtonId
            val selectedSizeId = sizeRadioGroup.checkedRadioButtonId

            var totalPrice = 0

            if (sprinklesCheckbox.isChecked) {
                selectedToppings.add(sprinklesCheckbox.text.toString())
                totalPrice += 10
            }
            if (chocolatebitsCheckbox.isChecked) {
                selectedToppings.add(chocolatebitsCheckbox.text.toString())
                totalPrice += 25
            }
            if (nipsCheckbox.isChecked) {
                selectedToppings.add(nipsCheckbox.text.toString())
                totalPrice += 20
            }
            if (oreocookiesCheckbox.isChecked) {
                selectedToppings.add(oreocookiesCheckbox.text.toString())
                totalPrice += 35
            }
            if (stickoCheckbox.isChecked) {
                selectedToppings.add(stickoCheckbox.text.toString())
                totalPrice += 8
            }
            if (marshmallowCheckbox.isChecked) {
                selectedToppings.add(marshmallowCheckbox.text.toString())
                totalPrice += 13
            }

            val sizePrice = when (selectedSizeId) {
                R.id.pequenowaffles -> 69
                R.id.medianowaffle -> 98
                R.id.grandewaffle -> 148
                else -> 0
            }

            totalPrice += sizePrice


            if (selectedFlavourId != -1) {



                val intent = Intent(this, SecondActivity::class.java)

                // Get the selected flavour radio button
                val selectedFlavourRadioButton = findViewById<RadioButton>(selectedFlavourId)
                // Get the selected size radio button
                val selectedSizeRadioButton = findViewById<RadioButton>(selectedSizeId)

                val selectedFlavourText = selectedFlavourRadioButton.text.toString()
                val selectedSizeText = selectedSizeRadioButton.text.toString()

                intent.putExtra("flavour", selectedFlavourText)
                intent.putExtra("size", selectedSizeText)
                intent.putStringArrayListExtra("toppings", ArrayList(selectedToppings))
                intent.putExtra("totalPrice", totalPrice)
                startActivity(intent)


            }
        }
    }

}