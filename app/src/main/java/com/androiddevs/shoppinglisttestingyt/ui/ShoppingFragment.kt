package com.androiddevs.shoppinglisttestingyt.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.shoppinglisttestingyt.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ShoppingFragment: Fragment(R.layout.fragment_shopping) {

    private val shoppingViewModel: ShoppingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingViewModel.printDependencies()
//        shoppingViewModel.insertShoppingItem("item1","20","100")
        shoppingViewModel.shoppingItems.observe(viewLifecycleOwner, Observer {
            Timber.d("shopping list = ${it}")
        })
    }
}