package com.twf.tritimings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twf.tritimings.TriTheme
import org.jetbrains.compose.resources.painterResource
import tritimings.composeapp.generated.resources.Res
import tritimings.composeapp.generated.resources.dropdown

// todo: move the distances into something else for type safety

@Composable
fun DropDown(
    selectedDistance: String = "Sprint",
    onDistanceSelected: (String) -> Unit = {}
) {
    val surfaceLow = Color(0xFFF6F3EC)
    var expanded by remember { mutableStateOf(false) }
    val distances = listOf(
        "Sprint", "Olympic", "70.3", "Iron"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "RACE DISTANCE",
            style = MaterialTheme.typography.labelLarge,
            color = Color(0xFF8C4B3E),
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(surfaceLow)
                    .clickable { expanded = true }
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = selectedDistance,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Medium
                )

                Icon(
                    painterResource(Res.drawable.dropdown),
                    contentDescription = "Expand",
                    tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(Color.White)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    distances.forEach { distance ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = distance,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (distance == selectedDistance) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                )
                            },
                            onClick = {
                                onDistanceSelected(distance)
                                expanded = false
                            },
                            modifier = Modifier.background(
                                if (distance == selectedDistance) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                                else Color.Transparent
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DropDownPreview() {
    TriTheme {
        DropDown()
    }
}