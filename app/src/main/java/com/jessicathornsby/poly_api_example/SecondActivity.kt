package com.jessicathornsby.poly_api_example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import processing.android.PFragment
import processing.core.PApplet
import processing.core.PConstants
import processing.core.PShape
import java.io.File

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        displayAsset()
    }


    private fun displayAsset() {
        val canvas3D = object : PApplet() {

            var polyAsset: PShape? = null

            override fun settings() {
                fullScreen(PConstants.P3D)
            }

            override fun setup() {
                polyAsset = loadShape(File(filesDir, "globeAsset.obj").absolutePath)
            }

            override fun draw() {
                background(0)

                scale(-10f)
                translate(-50f,-100f, 10f)
                shape(polyAsset)
            }
        }
        val assetView = PFragment(canvas3D)
        assetView.setView(asset_view, this)
    }
}
