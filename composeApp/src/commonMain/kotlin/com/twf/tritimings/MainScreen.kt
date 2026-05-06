package com.twf.tritimings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.twf.tritimings.components.BikeCard
import com.twf.tritimings.components.DropDown
import com.twf.tritimings.components.RunCard
import com.twf.tritimings.components.SwimCard
import com.twf.tritimings.components.ToggleSwitch
import com.twf.tritimings.components.Topbar
import com.twf.tritimings.components.TotalPill
import com.twf.tritimings.components.TransitionCard


@Composable
fun MainScreen(viewModel: MainViewModel = viewModel { MainViewModel() }) {

    MainLayout(
        viewModel.swimState,
        viewModel.bikeState,
        viewModel.runState,
        viewModel.t1state,
        viewModel.t2state,
        viewModel.isMetric,
        { selectedDistance -> viewModel.updateDistance(selectedDistance) },
        viewModel.distance,
        { newIsMetric -> viewModel.toggleMetric(newIsMetric) },
        viewModel.totalValue
    )

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainLayout(
    swimState: TextFieldState,
    bikeState: TextFieldState,
    runState: TextFieldState,
    t1state: TextFieldState,
    t2state: TextFieldState,
    isMetric: Boolean,
    onDistanceSelected: (String) -> Unit,
    selectedDistance: String,
    onToggle: (Boolean) -> Unit,
    total: String?
) {
    var swimUnit: String
    var bikeUnit: String
    var runUnit: String
    if (isMetric) {
        swimUnit = "min/100m"
        bikeUnit = "kph"
        runUnit = "min/km"
    } else {
        swimUnit = "min/100y"
        bikeUnit = "mph"
        runUnit = "min/mi"
    }
    Scaffold(topBar = { Topbar() }) { paddingValues ->
        Column(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(paddingValues)
                .imePadding()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Welcome To Tri Timings", style = MaterialTheme.typography.headlineLargeEmphasized,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                "Input your goal paces, and calculate your total expected time!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            DropDown(selectedDistance, onDistanceSelected)
            ToggleSwitch(isMetric, onToggle)
            SwimCard(placeholderUnit = swimUnit, textFieldState = swimState)
            BikeCard(placeholderUnit = bikeUnit, textFieldState = bikeState)
            RunCard(placeholderUnit = runUnit, textFieldState = runState)
            TransitionCard(t1State = t1state, t2State = t2state)
            if (total != null) {
                TotalPill(total)
            } else (TotalPill("--:--:--"))
        }
    }
}

@Preview
@Composable
fun PreviewMainLayout() {
    TriTheme {
        MainLayout(
            TextFieldState(),
            TextFieldState(),
            TextFieldState(),
            TextFieldState(),
            TextFieldState(),
            isMetric = true,
            onDistanceSelected = {},
            selectedDistance = "Sprint",
            onToggle = {},
            "1:23:45"
        )
    }
}
