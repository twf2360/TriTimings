package com.twf.tritimings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import tritimings.composeapp.generated.resources.leaf

@Composable
fun Topbar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f))
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .statusBarsPadding()
            .height(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painterResource(Res.drawable.leaf),
                contentDescription = "TriTimings",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "TriTimings",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White.copy(alpha = 0.3f))
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TriTheme {
        Topbar()
    }
}