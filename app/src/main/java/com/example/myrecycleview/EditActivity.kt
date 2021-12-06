package com.example.myrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrecycleview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private val arrayID = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5)
    private var index = 0
    private var imageId = arrayID[0]
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        btnNext.setOnClickListener{
            index++
            if(index > arrayID.size - 1) index = 0
            imageId = arrayID[index]
            imageView.setImageResource(imageId)
        }
        btnPrev.setOnClickListener{
            index--
            if(index < 0) index = 4
            if(index > 4) index = 0
            imageId = arrayID[index]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val image = Image(imageId, edTitle.text.toString(), edDesk.text.toString())
            val editIntent = Intent().apply {
                putExtra("image",  image)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}