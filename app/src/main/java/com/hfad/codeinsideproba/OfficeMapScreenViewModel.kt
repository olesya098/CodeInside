package com.hfad.codeinsideproba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.codeinsideproba.model.OperationState
import com.hfad.codeinsideproba.model.Workstation
import com.hfad.codeinsideproba.network.WorkstationService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OfficeMapScreenViewModel : ViewModel() {
    private val _coworking = MutableStateFlow<List<Workstation>?>(null)
    val coworking = _coworking.asStateFlow()

    private val _floorThree = MutableStateFlow<List<Workstation>?>(null)
    val floorThree = _floorThree.asStateFlow()

    private val _floorFour = MutableStateFlow<List<Workstation>?>(null)
    val floorFour = _floorFour.asStateFlow()

    private val _floorSix = MutableStateFlow<List<Workstation>?>(null)
    val floorSix = _floorSix.asStateFlow()

   private val _floorState = MutableStateFlow<OperationState>(OperationState.Coworking)
    val floorState = _floorState.asStateFlow()

    init {
        getCoworkingWorkstations()
        getFloorThreeWorkstation()
        getFloorFourWorkstation()
        getFloorSixWorkstation()
    }

    fun updateFloorState(operationState: OperationState){
        viewModelScope.launch {
            _floorState.value = operationState
        }
    }

    fun getCoworkingWorkstations() {
        viewModelScope.launch {
            _coworking.value = WorkstationService().getCoworkingWorkstations()
        }
    }

    fun getFloorThreeWorkstation() {
        viewModelScope.launch {
            _floorThree.value = WorkstationService().getFloorThreeWorkstation()
        }
    }
    fun getFloorFourWorkstation() {
        viewModelScope.launch {
            _floorFour.value = WorkstationService().getFloorFourWorkstation()
        }
    }
    fun getFloorSixWorkstation() {
        viewModelScope.launch {
            _floorSix.value = WorkstationService().getFloorSixWorkstation()
        }
    }
}