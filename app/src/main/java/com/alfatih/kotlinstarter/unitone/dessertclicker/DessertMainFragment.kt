package com.alfatih.kotlinstarter.unitone.dessertclicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.FragmentDessertMainBinding


class DessertMainFragment : Fragment() {
    private lateinit var binding: FragmentDessertMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dessert_main, container, false
        )
        val image_list = listOf(
            R.drawable.honeycomb,
            R.drawable.donut,
            R.drawable.froyo,
            R.drawable.cupcake
        )
        var countIndex = 0
        var counts = 0
        var price: Double = 0.0
        var totaPrice = 0.0
        binding.dessertImage.setImageResource(image_list[countIndex])
        binding.nextDessetImageBtn.setOnClickListener {
            //review this problem
            if (countIndex >= image_list.indexOf(image_list.last())) {
                countIndex = image_list.indexOf(image_list.last())
                changeNextImage(binding.dessertImage, image_list, countIndex)
            } else {
                countIndex++
                changeNextImage(binding.dessertImage, image_list, countIndex)

            }

        }
        binding.backDessertImageBtn.setOnClickListener {
            if (countIndex <= image_list.indexOf(image_list.first())) {
                countIndex = image_list.indexOf(image_list.first())
                changeBackImage(binding.dessertImage, image_list, countIndex)
            } else {
                countIndex--
                changeBackImage(binding.dessertImage, image_list, countIndex)
            }
        }
        binding.buyBtn.setOnClickListener {
            counts++
            var currentPrice = calculatePric(countIndex, image_list, price)
            totaPrice += currentPrice
            binding.textViewTotalPrice.text = totaPrice.toString()
            binding.textCount.text = counts.toString()
        }
        return binding.root
    }

    fun changeNextImage(imageView: ImageView, list: List<Int>, nextIndex: Int) {
        var count = nextIndex
        if (count < list.size) {
            imageView.setImageResource(list[count++])
        } else {
            /* no-op */
        }
    }

    /**
     * fun change the current img to pre img
     * using @param imageView and @param backIndex of the
     * @param list
     */
    fun changeBackImage(imageView: ImageView, list: List<Int>, backIndex: Int) {
        var count = backIndex
        if (count > list.indexOf(list.first())) {
            imageView.setImageResource(list[count--])
        } else {
            /* no-op */
        }
    }

    //func to calculate the price of the current img using index of the list
    //and return it as double
    fun calculatePric(
        countIndex: Int,
        list: List<Int>,
        price: Double
    ): Double {
        var countIndex = countIndex
        var price = price
        for (i in list.indexOf(list.first())..list.indexOf(list.last())) {
            when (countIndex) {
                0 -> price = 10.5
                1 -> price = 20.30
                2 -> price = 30.50
                3 -> price = 40.90
                else -> price
            }
        }
        return price
    }
}