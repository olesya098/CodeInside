package com.hfad.codeinsideproba.model

sealed class OperationState {
    data object Coworking : OperationState()
    data object FloorThree : OperationState()
    data object FloorFour : OperationState()
    data object FloorSix : OperationState()
}