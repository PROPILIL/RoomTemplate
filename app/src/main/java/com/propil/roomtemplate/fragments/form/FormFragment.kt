package com.propil.roomtemplate.fragments.form

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputEditText
import com.propil.roomtemplate.R
import com.propil.roomtemplate.data.BeerModel
import com.propil.roomtemplate.data.BeerViewModel


class FormFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var addImage: ImageView
    private lateinit var beerBrandField: TextInputEditText
    private lateinit var chipGroup: ChipGroup
    private lateinit var slider_amount: TextView
    private lateinit var slider: Slider
    private lateinit var beerDescription: TextInputEditText

    private val beerViewModel: BeerViewModel by lazy{
        ViewModelProvider(this)[BeerViewModel::class.java]

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.button_add_beer)
        addImage = view.findViewById(R.id.add_image_image_view)
        beerBrandField = view.findViewById(R.id.beer_brand_input_field)
        chipGroup = view.findViewById(R.id.chip_group)
        slider = view.findViewById(R.id.form_fragment_slider)
        slider_amount = view.findViewById(R.id.volume_amount)
        beerDescription = view.findViewById(R.id.beer_description_input_field)

        button.setOnClickListener(View.OnClickListener {
            insertDataToDatabase()
        })

    }

    private fun insertDataToDatabase() {
        val beerBrand = beerBrandField.text.toString()
        val beerDescription = beerDescription.text.toString()

        if(inputCheck(beerBrand, beerDescription)) {
            //create BeerModel object
            val beer = BeerModel(0, beerBrand, beerDescription,
                "", "", 0.0, 0 )
            //add beer to Database
            beerViewModel.addBeer(beer)
            Toast.makeText(requireContext(), "Beer successfully added", Toast.LENGTH_LONG).show()
            // navigate back to listFragment
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Something wrong", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(beerBrand : String, beerDescription: String): Boolean {
        return !(TextUtils.isEmpty(beerBrand) && TextUtils.isEmpty(beerDescription))
    }
}