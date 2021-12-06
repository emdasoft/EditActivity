package com.example.myrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    private val adapter = ImageAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addImage(it.data?.getSerializableExtra("image") as Image)
            }
        }
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            btnAdd.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }


        }
    }
}