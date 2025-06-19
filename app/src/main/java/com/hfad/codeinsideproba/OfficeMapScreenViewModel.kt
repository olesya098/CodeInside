package com.hfad.codeinsideproba

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.codeinsideproba.model.FloorModel
import com.hfad.codeinsideproba.model.OperationState
import com.hfad.codeinsideproba.model.Workstation
import com.hfad.codeinsideproba.network.WorkstationService
import com.hfad.codeinsideproba.network.getConferenceFourWorkstations
import com.hfad.codeinsideproba.network.getConferenceSixWorkstations
import com.hfad.codeinsideproba.network.getCoworkingWorkstations
import com.hfad.codeinsideproba.network.getFloorFourWorkstation
import com.hfad.codeinsideproba.network.getFloorSixWorkstation
import com.hfad.codeinsideproba.network.getFloorThreeWorkstation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OfficeMapScreenViewModel : ViewModel() {
    private val _coworking = MutableStateFlow<FloorModel?>(null)
    val coworking = _coworking.asStateFlow()

    private val _floorThree = MutableStateFlow<FloorModel?>(null)
    val floorThree = _floorThree.asStateFlow()

    private val _floorFour = MutableStateFlow<FloorModel?>(null)
    val floorFour = _floorFour.asStateFlow()

    private val _floorSix = MutableStateFlow<FloorModel?>(null)
    val floorSix = _floorSix.asStateFlow()

    private val _conferenceFour = MutableStateFlow<FloorModel?>(null)
    val conferenceFour = _conferenceFour.asStateFlow()

    private val _conferenceSix = MutableStateFlow<FloorModel?>(null)
    val conferenceSix = _conferenceSix.asStateFlow()

   private val _floorState = MutableStateFlow<OperationState>(OperationState.Coworking)
    val floorState = _floorState.asStateFlow()

    init {
        getCoworkingWorkstations()
        getFloorThreeWorkstation()
        getFloorFourWorkstation()
        getFloorSixWorkstation()
        getConferenceFourWorkstations()
        getConferenceSixWorkstations()
    }

    fun updateFloorState(operationState: OperationState){
        viewModelScope.launch {
            _floorState.value = operationState
        }
    }

    fun getCoworkingWorkstations()  {
        viewModelScope.launch {
            _coworking.value = WorkstationService().getCoworkingWorkStations()
        }
    }

    fun getFloorThreeWorkstation() {
        viewModelScope.launch {
            _floorThree.value = WorkstationService().getFloorThreeWorkStation()
        }
    }
    fun getFloorFourWorkstation() {
        viewModelScope.launch {
            _floorFour.value = WorkstationService().getFloorFourWorkStation()
        }
    }
    fun getFloorSixWorkstation() {
        viewModelScope.launch {
            _floorSix.value = WorkstationService().getFloorSixWorkStation()
        }
    }
    fun getConferenceFourWorkstations() {
        viewModelScope.launch {
            _conferenceFour.value = WorkstationService().getConferenceFourWorkStations()
        }
    }
    fun getConferenceSixWorkstations() {
        viewModelScope.launch {
            _conferenceSix.value = WorkstationService().getConferenceSixWorkStations()
        }
    }
}