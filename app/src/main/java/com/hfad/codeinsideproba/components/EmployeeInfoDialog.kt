package com.hfad.codeinsideproba.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hfad.codeinsideproba.model.Workstation

@Composable
fun EmployeeInfoDialog(workstation: Workstation, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Место ${workstation.id}") },
        text = {
            Column {
                Text(text = workstation.employeeName)
                Text(text = workstation.position)
            }
        },
        confirmButton = {
            Text(
                text = "Закрыть",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onDismiss() }
            )
        }
    )
}

