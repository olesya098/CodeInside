package com.hfad.codeinsideproba.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hfad.codeinsideproba.ui.theme.yello

@Composable
fun FloatingActionButtonFun(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    androidx.compose.material3.FloatingActionButton(
        onClick = {
            onClick()

        },
        containerColor = color,
        modifier = Modifier.padding(bottom = 8.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Text(text = text, color = Color.Black)
    }
}