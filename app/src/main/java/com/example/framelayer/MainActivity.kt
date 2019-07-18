package com.example.framelayer

import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val imageUrl = "https://b.zmtcdn.com/data/brand_creatives/logos/1e75a571ab98490b81adc3a67a95470b_1492873478.png?fit=around%7C180%3A180"
        val videoUrl = "https://v.zmtcdn.com/showcase_Frappucino.mp4"

        val videoView: VideoView = findViewById(R.id.videoView)
        videoView.setVideoURI(Uri.parse(videoUrl))
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        videoView.start()

        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setImageURI(Uri.parse(imageUrl))
        Picasso.get().load(imageUrl).into(imageView1)

        val imageView2: ImageView = findViewById(R.id.imageView2)
        imageView2.setImageURI(Uri.parse(imageUrl))
        Glide.with(this).load(imageUrl).override(100,100).into(imageView2)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
