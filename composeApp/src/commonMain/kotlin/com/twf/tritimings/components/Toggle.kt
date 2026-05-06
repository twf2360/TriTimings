package com.twf.tritimings.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twf.tritimings.TriTheme

@Composable
fun ToggleSwitch(
    isMetric: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val surfaceLow = Color(0xFFF6F3EC)

    val alignment by animateFloatAsState(
        targetValue = if (isMetric) -1f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "ToggleAnimation"
    )
    Box(
        modifier = Modifier.width(200.dp).height(48.dp).clip(RoundedCornerShape(24.dp))
            .background(surfaceLow).clickable() { onToggle(!isMetric) }
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .align(BiasAlignment(alignment, 0f))
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.primary))
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "METRIC",
                    style = MaterialTheme.typography.labelLarge,
                    color = if (isMetric) Color.White else MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "IMPERIAL",
                    style = MaterialTheme.typography.labelLarge,
                    color = if (!isMetric) Color.White else MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
        }

    }
}

@Preview
@Composable
fun TogglePreview() {
    var state by mutableStateOf(false)
    TriTheme {
        ToggleSwitch(state) { updated -> state = updated }
    }
}

