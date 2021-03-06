package com.smartherd.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.globofly.R
import com.smartherd.globofly.databinding.ActivityDestinyDetailBinding
import com.smartherd.globofly.databinding.ActivityWelcomeBinding
import com.smartherd.globofly.helpers.SampleData
import com.smartherd.globofly.models.Destination



class DestinationDetailActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDestinyDetailBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDestinyDetailBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)


		setSupportActionBar(binding.detailToolbar)
		// Show the Up button in the action bar.
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val bundle: Bundle? = intent.extras

		if (bundle?.containsKey(ARG_ITEM_ID)!!) {

			val id = intent.getIntExtra(ARG_ITEM_ID, 0)

			loadDetails(id)

			initUpdateButton(id)

			initDeleteButton(id)
		}
	}

	private fun loadDetails(id: Int) {

		// To be replaced by retrofit code
		val destination = SampleData.getDestinationById(id)

		destination?.let {
			binding.etCity.setText(destination.city)
			binding.etDescription.setText(destination.description)
			binding.etCountry.setText(destination.country)

			binding.collapsingToolbar.title = destination.city
		}
	}

	private fun initUpdateButton(id: Int) {

		binding.btnUpdate.setOnClickListener {

			val city = binding.etCity.text.toString()
			val description = binding.etDescription.text.toString()
			val country = binding.etCountry.text.toString()

            // To be replaced by retrofit code
            val destination = Destination()
            destination.id = id
            destination.city = city
            destination.description = description
            destination.country = country

            SampleData.updateDestination(destination);
            finish() // Move back to DestinationListActivity
		}
	}

	private fun initDeleteButton(id: Int) {

		binding.btnDelete.setOnClickListener {

            // To be replaced by retrofit code
            SampleData.deleteDestination(id)
            finish() // Move back to DestinationListActivity
		}
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val id = item.itemId
		if (id == android.R.id.home) {
			navigateUpTo(Intent(this, DestinationListActivity::class.java))
			return true
		}
		return super.onOptionsItemSelected(item)
	}

	companion object {

		const val ARG_ITEM_ID = "item_id"
	}
}
