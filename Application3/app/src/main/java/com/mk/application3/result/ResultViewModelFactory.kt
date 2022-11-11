package com.mk.application3.result

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mk.application3.database.DatabaseDao

class ResultViewModelFactory(var dataSource:DatabaseDao,var application: Application):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ResultViewModel::class.java))
            return ResultViewModel(dataSource, application) as T
        throw IllegalArgumentException("IllegalArgument")
    }
}