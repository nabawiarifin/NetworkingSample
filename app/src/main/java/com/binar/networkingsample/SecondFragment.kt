package com.binar.networkingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binar.networkingsample.databinding.FragmentSecondBinding
import com.bumptech.glide.Glide


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = args.items.name
        val category = args.items.category
        val createdAt = args.items.createdAt
        val finishRentAt = args.items.finishRentAt
        val id = args.items.id
        val image = args.items.image
        val price = args.items.price
        val startRentAt = args.items.price
        val status = args.items.status
        val updatedAt = args.items.updatedAt

        with(binding) {
            tvName.text = "Name: $name"
            tvCategory.text = "Category: $category"
            tvCreatedAt.text = "Created at: $createdAt"
            tvFinishRentAt.text = "Finish rent at: $finishRentAt"
            tvId.text = "ID: ${id.toString()}"
            tvPrice.text = "Price: ${price.toString()}"
            tvStartRentAt.text = "Start rent at: ${startRentAt.toString()}"
            tvStatus.text = "Status: ${status.toString()}"
            tvUpdatedAt.text = "Updated at: ${updatedAt}"
        }

        Glide.with(this)
            .load(image)
            .into(binding.ivCar)
    }

}