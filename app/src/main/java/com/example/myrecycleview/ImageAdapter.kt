package com.example.myrecycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecycleview.databinding.ImageItemBinding

class ImageAdapter:RecyclerView.Adapter<ImageAdapter.ImageHolder>() {
    private var imageArray = ArrayList<Image>()

    class ImageHolder(item: View):RecyclerView.ViewHolder(item) {
        private var binding = ImageItemBinding.bind(item)
        private val limit = 10
        fun bind(image: Image) = with(binding){
            iv.setImageResource(image.imageId)
            textTitle.text = image.imageTitle
            if(image.desc.length <= limit) textID.text = image.desc
            if(image.desc.length > limit) {
                val tmpText = " ${image.desc.toString().substring(0, 10)} ..."
                textID.text = tmpText
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageArray[position])
    }

    override fun getItemCount(): Int {
        return imageArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(image: Image){
        imageArray.add(image)
        notifyDataSetChanged()
    }
}