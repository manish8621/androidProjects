package com.mk.application1.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mk.application1.database.DatabaseDao

class HomeViewModelFactory(var dataSource:DatabaseDao,var application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel(dataSource,application) as T
        throw IllegalArgumentException("IllegalArgument")
    }
}