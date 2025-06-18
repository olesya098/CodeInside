package com.hfad.codeinsideproba.OfficeMapScreen

import NumberSelectionFab
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hfad.codeinsideproba.OfficeMapScreenViewModel
import com.hfad.codeinsideproba.R
import com.hfad.codeinsideproba.components.EditInfoDialog
import com.hfad.codeinsideproba.components.EmployeeInfoDialog
import com.hfad.codeinsideproba.components.WorkstationPoint
import com.hfad.codeinsideproba.model.OperationState
import com.hfad.codeinsideproba.model.Workstation

@Composable
fun OfficeMapScreen(viewModel: OfficeMapScreenViewModel) {
    // Состояние для масштабирования и перемещения
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val coworking = viewModel.coworking.collectAsState()
    val floorThree = viewModel.floorThree.collectAsState()
    val floorFour = viewModel.floorFour.collectAsState()
    val floorSix = viewModel.floorSix.collectAsState()
    val floorState = viewModel.floorState.collectAsState()
    var show by remember { mutableStateOf(false) }

    // Список рабочих мест с относительными координатами (0.0-1.0)


    var selectedWorkstation by remember { mutableStateOf<Workstation?>(null) }

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { centroid, pan, zoom, rotation ->
                    scale = (scale * zoom).coerceIn(0.5f, 3f)
                    offset += pan
                }
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                        translationX = offset.x,
                        translationY = offset.y
                    )
            ) {
                when (floorState.value) {
                    OperationState.Coworking -> {
                        Image(
                            painter = painterResource(id = R.drawable.korvorking),
                            contentDescription = "Office Map",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Точки рабочих мест
                        coworking.value?.forEach { workstation ->
                            WorkstationPoint(
                                workstation = workstation,
                                onClick = { selectedWorkstation = workstation },
                                onLongClick = {
                                    show = true

                                },
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(
                                        x = (workstation.x * maxWidth.value).dp,
                                        y = (workstation.y * maxHeight.value).dp
                                    )
                            )
                        }
                    }

                    OperationState.FloorThree -> {
                        Image(
                            painter = painterResource(id = R.drawable.flover3),
                            contentDescription = "Office Map",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Точки рабочих мест
                        floorThree.value?.forEach { workstation ->
                            WorkstationPoint(
                                workstation = workstation,
                                onClick = { selectedWorkstation = workstation },
                                onLongClick = {
                                    show = true

                                },
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(
                                        x = (workstation.x * maxWidth.value).dp,
                                        y = (workstation.y * maxHeight.value).dp
                                    )
                            )
                        }
                    }
                    OperationState.FloorFour -> {
                        Image(
                            painter = painterResource(id = R.drawable.floor4),
                            contentDescription = "Office Map",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Точки рабочих мест
                        floorFour.value?.forEach { workstation ->
                            WorkstationPoint(
                                workstation = workstation,
                                onClick = { selectedWorkstation = workstation },
                                onLongClick = {
                                    show = true

                                },
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(
                                        x = (workstation.x * maxWidth.value).dp,
                                        y = (workstation.y * maxHeight.value).dp
                                    )
                            )
                        }
                    }
                    OperationState.FloorSix -> {
                        Image(
                            painter = painterResource(id = R.drawable.floor6),
                            contentDescription = "Office Map",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Точки рабочих мест
                        floorSix.value?.forEach { workstation ->
                            WorkstationPoint(
                                workstation = workstation,
                                onClick = { selectedWorkstation = workstation },
                                onLongClick = {
                                    show = true

                                },
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(
                                        x = (workstation.x * maxWidth.value).dp,
                                        y = (workstation.y * maxHeight.value).dp
                                    )
                            )
                        }
                    }

                }

            }
            if (show) {
                EditInfoDialog(onDismiss = { show = false })

            }
            NumberSelectionFab(
                modifier = Modifier.align(
                    Alignment.BottomEnd
                ),
                viewModel = viewModel,

                )
        }

        selectedWorkstation?.let { workstation ->
            EmployeeInfoDialog(
                workstation = workstation,
                onDismiss = { selectedWorkstation = null }
            )
        }
    }
}