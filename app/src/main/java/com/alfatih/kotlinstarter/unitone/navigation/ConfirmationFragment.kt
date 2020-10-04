package com.alfatih.kotlinstarter.unitone.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.FragmentConfirmationBinding


class ConfirmationFragment : Fragment() {
    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentConfirmationBinding>(
            inflater, R.layout.fragment_confirmation, container, false
        )

        hidKeyboard(container)

        val args = ConfirmationFragmentArgs.fromBundle(requireArguments())
        var textView = binding.confirmationMessage
        var message = getSharedText(args)
        setSharedText(textView, message)

        //create share btn in app bar

        setHasOptionsMenu(true)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        val args = ConfirmationFragmentArgs.fromBundle(requireArguments())
        var message = getSharedText(args)
        if (getSharedIntent(message)?.resolveActivity(requireActivity().packageManager) == null) {
            menu.findItem(R.id.share_item_id).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var message = getSharedText(
            args = ConfirmationFragmentArgs.fromBundle(
                requireArguments()
            )
        )
        when (item.itemId) {
            R.id.share_item_id -> startActivity(getSharedIntent(message))
        }
        return super.onOptionsItemSelected(item)

    }

    fun hidKeyboard(v: View?) {
        // Hide the keyboard.
        val inputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(v?.windowToken, 0)
    }

    fun getSharedText(args: ConfirmationFragmentArgs?): String? {
        var message = "${args?.amountMoney} sent to ${args?.recName}"
        return message
    }

    fun setSharedText(textView: TextView?, message: String?) {
        textView?.setText(message)
    }

    fun getSharedIntent(message: String?): Intent? {
        val sharedIntent = Intent(Intent.ACTION_SEND)
        sharedIntent.setType("text/plain")
        sharedIntent.putExtra(Intent.EXTRA_TEXT, message)
        return sharedIntent
    }

}