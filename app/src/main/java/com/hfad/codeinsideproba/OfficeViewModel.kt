package com.hfad.codeinsideproba

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.codeinsideproba.network.WorkstationService
import kotlinx.coroutines.launch

class OfficeViewModel: ViewModel() {
//    init {
//        initializeWorkstation()
//    }
    fun initializeWorkstation(){
        viewModelScope.launch {
            try {
                WorkstationService().initializeWorkstation()
            }catch (e: Exception){
                Log.e("My","Exception")
            }
        }
    }
}