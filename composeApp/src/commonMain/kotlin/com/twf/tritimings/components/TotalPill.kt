package com.twf.tritimings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twf.tritimings.TriTheme

@Composable
fun TotalPill(
    totalTime: String,
    modifier: Modifier = Modifier
) {
    val sageSurface = Color(0xFFE8F5E9)
    val terracotta = Color(0xFF8C4B3E)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        shape = RoundedCornerShape(40.dp),
        colors = CardDefaults.cardColors(
            containerColor = sageSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ESTIMATED TOTAL",
                style = MaterialTheme.typography.labelLarge,
                color = terracotta,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = totalTime,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-1).sp
            )

        }
    }

}
@Preview
@Composable
fun PillPreview() {
    TriTheme {
        TotalPill("2:44:12")
    }
}
