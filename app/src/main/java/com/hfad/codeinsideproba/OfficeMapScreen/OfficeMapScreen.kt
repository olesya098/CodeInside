package com.hfad.codeinsideproba.OfficeMapScreen

import NumberSelectionFab
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.codeinsideproba.OfficeMapScreenViewModel
import com.hfad.codeinsideproba.R
import com.hfad.codeinsideproba.components.EditInfoDialog
import com.hfad.codeinsideproba.components.EmployeeInfoDialog
import com.hfad.codeinsideproba.components.WorkstationPoint
import com.hfad.codeinsideproba.model.OperationState
import com.hfad.codeinsideproba.model.Workstation
import com.hfad.codeinsideproba.ui.theme.yello

@Composable
fun OfficeMapScreen(viewModel: OfficeMapScreenViewModel) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val coworking = viewModel.coworking.collectAsState()
    val floorThree = viewModel.floorThree.collectAsState()
    val floorFour = viewModel.floorFour.collectAsState()
    val floorSix = viewModel.floorSix.collectAsState()
    val conferenceFour = viewModel.conferenceFour.collectAsState()
    val conferenceSix = viewModel.conferenceSix.collectAsState()
    val floorState = viewModel.floorState.collectAsState()
    var show by remember { mutableStateOf(false) }

    val pointScale = (1f / scale).coerceIn(0.47f, 2f)

    var selectedWorkstation by remember { mutableStateOf<Workstation?>(null) }

    // Получаем название текущего этажа
    val floorTitle = when (floorState.value) {
        OperationState.Coworking -> "Коворкинг"
        OperationState.FloorThree -> "3 Этаж"
        OperationState.FloorFour -> "4 Этаж"
        OperationState.FloorSix -> "6 Этаж"
        OperationState.ConferenceFour -> "Переговорка 4 этаж"
        OperationState.ConferenceSix -> "Переговорка 6 этаж"
        else -> ""
    }

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
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(100.dp)

                .background(Color.Black)
                .border(
                    width = 1.5.dp,
                    color = Color.Black.copy(alpha = 0.8f),
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(Color.Black)
                    .border(
                        width = 1.5.dp,
                        color = yello.copy(alpha = 0.8f),
                    )
            ) {
                Text(
                    text = floorTitle,
                    color = yello,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }

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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
                        )
                    }
                }

                OperationState.ConferenceFour -> {
                    Image(
                        painter = painterResource(id = R.drawable.conference4),
                        contentDescription = "Office Map",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )

                    // Точки рабочих мест
                    conferenceFour.value?.forEach { workstation ->
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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
                        )
                    }
                }

                OperationState.ConferenceSix -> {
                    Image(
                        painter = painterResource(id = R.drawable.conference6),
                        contentDescription = "Office Map",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )

                    // Точки рабочих мест
                    conferenceSix.value?.forEach { workstation ->
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
                                .graphicsLayer {
                                    scaleX = pointScale
                                    scaleY = pointScale
                                }
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
