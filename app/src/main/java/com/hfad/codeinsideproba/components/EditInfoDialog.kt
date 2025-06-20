package com.hfad.codeinsideproba.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.serialization.json.JsonNull.content

@Composable
fun EditInfoDialog(
    title: String,
    descripton: String,
    onDismiss: () -> Unit,
    onTitle: (String) -> Unit,
    onDescription: (String) -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties()
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .widthIn(min = 280.dp, max = 560.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Добавление информации",
                    color = Color.Black,
                    lineHeight = 40.sp,
                    fontSize = 32.sp,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,
                )
                TextFields(
                    value = title,
                    text = "Название",
                    onvalChange = onTitle
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextFields(
                    value = descripton,
                    text = "Должность",
                    onvalChange = onDescription
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomButton(
                    title = "Добавить",
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )


            }
        }
    }
}

