package com.alfatih.kotlinstarter.unitone.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container, false
        )
        binding.sendMoneyBtn.setOnClickListener { v: View? ->
            v!!.findNavController().navigate(
                R.id.action_mainFragment_to_chooseResepientFragment
            )
        }
        binding.viewBalanceBtn.setOnClickListener { v: View? ->
            v!!.findNavController().navigate(
                R.id.action_mainFragment_to_viewBalanceFragment
            )
        }
        binding.viewTransactionsBtn.setOnClickListener { v: View? ->
            v!!.findNavController().navigate(
                R.id.action_mainFragment_to_viewTransactionFragment
            )
        }
        //dd code to implement behavior when the user taps the About menu item.
        setHasOptionsMenu(true)

        return binding.root

    }

    //dd the options menu and inflate the menu resource file.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    //method to take the appropriate action when the menu item is tapped. In this case,
    // the action is to navigate to the Fragment that has the same id
    // as the selected menu item.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        navController = Navigation.findNavController(view)
//        view.findViewById<Button>(R.id.view_balance_btn).setOnClickListener(this)
//        view.findViewById<Button>(R.id.send_money_btn).setOnClickListener(this)
//        view.findViewById<Button>(R.id.view_transactions_btn).setOnClickListener(this)
//
//    }

//    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.send_money_btn -> navController.navigate(
//                R.id.action_mainFragment_to_chooseResepientFragment
//            )
//            R.id.view_transactions_btn -> navController.navigate(
//                R.id.action_mainFragment_to_viewTransactionFragment
//            )
//            R.id.view_balance_btn -> navController.navigate(
//                R.id.action_mainFragment_to_viewBalanceFragment
//            )
//        }
//    }
}