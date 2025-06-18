package com.hfad.codeinsideproba.model

// Data class для хранения информации о рабочем месте
data class Workstation(
    // Уникальный идентификатор рабочего места
    val id: String,
    // Координата X для размещения на карте
    val x: Float,
    // Координата Y для размещения на карте
    val y: Float,
    // Имя сотрудника на этом месте
    val employeeName: String,
    // Должность сотрудника
    val position: String
)