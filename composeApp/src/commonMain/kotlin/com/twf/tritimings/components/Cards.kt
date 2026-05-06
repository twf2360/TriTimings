package com.twf.tritimings.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twf.tritimings.TriTheme
import com.twf.tritimings.domain.Unit
import org.jetbrains.compose.resources.painterResource
import tritimings.composeapp.generated.resources.Res
import tritimings.composeapp.generated.resources.bike
import tritimings.composeapp.generated.resources.run
import tritimings.composeapp.generated.resources.transition
import tritimings.composeapp.generated.resources.water


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SwimCard( modifier: Modifier = Modifier,
              placeholderUnit: String,
              textFieldState: TextFieldState
) {
    Card(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = 0.7f
            )
        ),

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth().padding(24.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    Modifier.size(48.dp).clip(shape = RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.water),
                        null,
                        Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Text("SWIM", style = MaterialTheme.typography.labelMediumEmphasized)
            }
            Text(
                "Target Pace",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            CardInputField(textFieldState, placeholderUnit)
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BikeCard(
    modifier: Modifier = Modifier,
    placeholderUnit: String,
    textFieldState: TextFieldState
) {
    Card(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = 0.7f
            )
        ),

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth().padding(24.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    Modifier.size(48.dp).clip(shape = RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.bike),
                        null,
                        Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                Text("BIKE", style = MaterialTheme.typography.labelMediumEmphasized)
            }
            Text(
                "Target Speed",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            CardInputField(textFieldState, placeholderUnit, isPace = false)
        }
    }
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun RunCard(
    modifier: Modifier = Modifier,
    placeholderUnit: String,
    textFieldState: TextFieldState
) {
    Card(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = 0.7f
            )
        ),

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth().padding(24.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    Modifier.size(48.dp).clip(shape = RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.run),
                        null,
                        Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }

                Text("RUN", style = MaterialTheme.typography.labelMediumEmphasized)
            }
            Text(
                "Target Pace",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            CardInputField(textFieldState, placeholderUnit)
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TransitionCard(modifier: Modifier = Modifier, t1State: TextFieldState, t2State: TextFieldState) {
    Card(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = 0.7f
            )
        ),

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth().padding(24.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    Modifier.size(48.dp).clip(shape = RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.transition),
                        null,
                        Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                Text("TRANSITION", style = MaterialTheme.typography.labelMediumEmphasized)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically ) {
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Transition 1", style = MaterialTheme.typography.bodyLarge)
                    CardInputField(t1State, "min:s")
                }
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Transition 2", style = MaterialTheme.typography.bodyLarge)
                    CardInputField(t2State, "min:s")
                }
            }
        }
    }
}

@Composable
fun CardInputField(state: TextFieldState, unitPlaceholder: String, isPace: Boolean = true) {
    var isFocused by remember { mutableStateOf(false) }

    val primaryGreen = MaterialTheme.colorScheme.primary
    val surfaceVariant = MaterialTheme.colorScheme.surfaceVariant
    val focusGlow = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
    val onSurface = MaterialTheme.colorScheme.onSurface

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .then(
                if (isFocused) {
                    Modifier.shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp),
                        spotColor = focusGlow,
                        ambientColor = focusGlow
                    )
                } else Modifier
            )
            .background(
                color = surfaceVariant.copy(alpha = 0.4f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = if (isFocused) 2.dp else 0.dp,
                color = if (isFocused) primaryGreen else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                state = state,
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = onSurface,
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (isPace) KeyboardType.Number else KeyboardType.Decimal
                ),
                outputTransformation = if (isPace) PaceOutputTransformation else null,
                modifier = Modifier
                    .weight(1f)
                    .onFocusChanged { isFocused = it.isFocused }
            )

            Text(
                text = unitPlaceholder,
                style = MaterialTheme.typography.labelMedium,
                color = onSurface.copy(alpha = 0.5f),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
object PaceOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (length < 3) return
        val reverseIndex2 = length - 2
        insert(reverseIndex2, ":")
    }
}


@Preview
@Composable
fun CardPreview() {
    TriTheme {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.verticalScroll(
            rememberScrollState()
        )) {
            SwimCard(Modifier, "min/100m", TextFieldState())
            BikeCard(Modifier, "kph", TextFieldState())
            RunCard(Modifier, "min/km", TextFieldState())
            TransitionCard(Modifier, TextFieldState(), TextFieldState())
        }
    }
}

