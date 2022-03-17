package com.smartherd.globofly.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.globofly.R
import com.smartherd.globofly.databinding.ActivityDestinyCreateBinding
import com.smartherd.globofly.helpers.SampleData
import com.smartherd.globofly.models.Destination


class DestinationCreateActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDestinyCreateBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding= ActivityDestinyCreateBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

		setSupportActionBar(binding.toolbar)
		val context = this

		// Show the Up button in the action bar.
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		binding.btnAdd.setOnClickListener {
			val newDestination = Destination()
			newDestination.city = binding.etCity.text.toString()
			newDestination.description = binding.etDescription.text.toString()
			newDestination.country = binding.etCountry.text.toString()

			// To be replaced by retrofit code
			SampleData.addDestination(newDestination)
            finish() // Move back to DestinationListActivity
		}
	}
}
