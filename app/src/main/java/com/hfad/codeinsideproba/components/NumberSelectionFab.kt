
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hfad.codeinsideproba.OfficeMapScreenViewModel
import com.hfad.codeinsideproba.components.FloatingActionButtonFun
import com.hfad.codeinsideproba.model.OperationState
import com.hfad.codeinsideproba.navigation.OfficeMapScreenRoute
import com.hfad.codeinsideproba.ui.theme.grey
import com.hfad.codeinsideproba.ui.theme.yello
@Composable
fun NumberSelectionFab(
    modifier: Modifier = Modifier,
    viewModel: OfficeMapScreenViewModel
) {
    var expanded by remember { mutableStateOf(false) }
    val floorState by viewModel.floorState.collectAsState()

    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        FloatingActionButton(
            onClick = { expanded = !expanded },
            containerColor = yello,
            modifier = modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                imageVector = if (expanded) Icons.Default.Close else Icons.Default.KeyboardArrowUp,
                contentDescription = if (expanded) "Закрыть" else "Открыть меню",
                tint = Color.Black
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(expandFrom = Alignment.Bottom),
            exit = fadeOut() + shrinkVertically(shrinkTowards = Alignment.Bottom)
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                FloatingActionButtonFun(
                    text = "К",
                    color = if (floorState == OperationState.Coworking) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.Coworking)
                    }
                )
                FloatingActionButtonFun(
                    text = "3",
                    color = if (floorState == OperationState.FloorThree) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.FloorThree)
                    }
                )
                FloatingActionButtonFun(
                    text = "4",
                    color = if (floorState == OperationState.FloorFour) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.FloorFour)
                    }
                )
                FloatingActionButtonFun(
                    text = "6",
                    color = if (floorState == OperationState.FloorSix) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.FloorSix)
                    }
                )
                FloatingActionButtonFun(
                    text = "П4",
                    color = if (floorState == OperationState.ConferenceFour) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.ConferenceFour)
                    }
                )
                FloatingActionButtonFun(
                    text = "П6",
                    color = if (floorState == OperationState.ConferenceSix) grey else Color.White,
                    onClick = {
                        viewModel.updateFloorState(OperationState.ConferenceSix)
                    }
                )
            }
        }
    }
}