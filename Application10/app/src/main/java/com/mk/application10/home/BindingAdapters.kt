package com.mk.application10.home

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mk.application10.R

@BindingAdapter("imgUrl")
fun bindImg(imageView: ImageView,url:String){
    val uri = url.toUri().buildUpon().scheme("https").build()
    Glide.with(imageView.context)
        .load(uri)
        .apply(RequestOptions().placeholder(R.drawable.ic_baseline_downloading_24))
        .error(R.drawable.ic_baseline_broken_image_24)
        .into(imageView)
}