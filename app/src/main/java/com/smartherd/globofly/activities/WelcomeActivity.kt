package com.smartherd.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.globofly.R
import com.smartherd.globofly.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity() {

	private lateinit var binding: ActivityWelcomeBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityWelcomeBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

		// To be replaced by retrofit code
		binding.message.text = "Black Friday! Get 50% cash back on saving your first spot."
	}

	fun getStarted(view: View) {
		val intent = Intent(this, DestinationListActivity::class.java)
		startActivity(intent)
		finish()
	}
}
