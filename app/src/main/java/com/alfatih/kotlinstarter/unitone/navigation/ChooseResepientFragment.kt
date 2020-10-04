package com.alfatih.kotlinstarter.unitone.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alfatih.kotlinstarter.R


class ChooseResepientFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_resepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_next_choose).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_cancel_choose).setOnClickListener(this)

        setHasOptionsMenu(true)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_next_choose -> {
                getTextName()
            }
            R.id.button_cancel_choose ->
                requireActivity().onBackPressed()
        }

    }

    private fun getTextName(v: EditText = requireView().findViewById(R.id.editText_choose_rec)) {
        if (v.text.isEmpty()) {
            Toast.makeText(
                context, "pleas enter your name",
                Toast.LENGTH_SHORT
            ).show()

        } else {
            var name: String = v.text.toString()


            navController.navigate(
                ChooseResepientFragmentDirections
                    .actionChooseResepientFragmentToSpecifyAmountFragment(name)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)

    }
}