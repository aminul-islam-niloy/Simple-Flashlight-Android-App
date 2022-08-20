package com.example.battijalao

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat




class MainActivity : AppCompatActivity() {

    private lateinit var cameraM: CameraManager
    private lateinit var powerBtn: ImageButton

    var isFlash = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        powerBtn = findViewById(R.id.on)

        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                flashLightOnRoOff(it)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnRoOff(v: View?) {

        if (!isFlash) {
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId, true)
            isFlash = true
            powerBtn.setImageResource(R.drawable.on)


        } else {
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId, false)

            isFlash = false
            powerBtn.setImageResource(R.drawable.off)

        }




    }
}