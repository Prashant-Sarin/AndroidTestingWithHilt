package com.androiddevs.shoppinglisttestingyt.ui

import androidx.lifecycle.ViewModel
import com.androiddevs.shoppinglisttestingyt.repositories.ShoppingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    @Inject @Named("Message") lateinit var message: String
//    @Inject lateinit var repository: ShoppingRepo

}