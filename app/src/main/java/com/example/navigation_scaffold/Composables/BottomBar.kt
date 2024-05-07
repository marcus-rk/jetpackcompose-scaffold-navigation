package com.example.navigation_scaffold.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    currentRoute: String?,
    onHomeClicked: () -> Unit
) {
    BottomAppBar(
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
                IconButton(onClick = onHomeClicked) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Profile",
                        tint = if (currentRoute == "profile") Color.Black else Color.Gray
                    )
                }
            }
        }
    )
}
