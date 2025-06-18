package com.hfad.codeinsideproba.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.hfad.codeinsideproba.model.Workstation

// Компонент точки рабочего места на карте
@Composable
fun WorkstationPoint(
    workstation: Workstation,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(22.dp)
            .clip(CircleShape)
            .background(Color.Red.copy(alpha = 0.6f))
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onClick() },
                    onLongPress = { onLongClick() } // Обработка долгого нажатия
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = workstation.id,
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )
    }
}