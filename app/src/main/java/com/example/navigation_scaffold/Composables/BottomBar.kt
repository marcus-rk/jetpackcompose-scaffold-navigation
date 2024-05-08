package com.example.navigation_scaffold.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    onHomeClicked: () -> Unit
) {
    BottomAppBar(
        containerColor = Color(0xFF6650a4),
        contentColor = Color.White,
        modifier = Modifier.height(56.dp), // Adjust the height as needed
        content = {
            Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
//                IconButton(onClick = onEventClicked) {
//                    Icon(
//                        Icons.Default.DateRange,
//                        contentDescription = "Event",
//                        tint = if (currentRoute == "event") Color.Black else Color.Gray
//                    )
//                }
                IconButton(onClick = onHomeClicked, modifier = Modifier.size(48.dp)) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    )
}
