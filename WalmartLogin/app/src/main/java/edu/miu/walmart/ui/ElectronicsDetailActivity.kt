package edu.miu.walmart.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.miu.walmart.model.Product
import edu.miu.walmart.databinding.ActivityElectronicsDetailBinding


class ElectronicsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityElectronicsDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product: Product? = intent.getSerializableExtra("product") as Product?
        product?.image?.let { binding.detailProductImage.setBackgroundResource(it) }
        binding.detailProductTitle.text = product?.title
        binding.detailProductColor.text = "Color: ${product?.color}"
        binding.detailProductNumber.text = "Walmart #: ${product?.itemId.toString()}"
        binding.detailProductDescription.text = "Item Description:\n${product?.desc}"
    }

}