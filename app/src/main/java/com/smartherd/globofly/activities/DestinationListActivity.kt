package com.smartherd.globofly.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.globofly.R
import com.smartherd.globofly.databinding.ActivityDestinyListBinding
import com.smartherd.globofly.databinding.ActivityWelcomeBinding
import com.smartherd.globofly.helpers.DestinationAdapter
import com.smartherd.globofly.helpers.SampleData

class DestinationListActivity : AppCompatActivity() {
		private lateinit var binding:ActivityDestinyListBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDestinyListBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

		setSupportActionBar(binding.toolbar)
		binding.toolbar.title = title

		binding.fab.setOnClickListener {
			val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
			startActivity(intent)
		}
	}

	override fun onResume() {
		super.onResume()

		loadDestinations()
	}

	private fun loadDestinations() {

        // To be replaced by retrofit code
		binding.destinyRecyclerView.adapter = DestinationAdapter(SampleData.DESTINATIONS)
    }
}
