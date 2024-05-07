package com.example.navigation_scaffold.Navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun EventNavGraph(eventNavController: NavHostController) {
    NavHost(
        navController = eventNavController,
        route = "event",
        startDestination = "event-1"
    ) {
        composable("event-1") {
            EventScreenMaker(eventNumber = 1, navController = eventNavController)
        }
        composable("event-2") {
            EventScreenMaker(eventNumber = 2, navController = eventNavController)
        }
        composable("event-3") {
            EventScreenMaker(eventNumber = 3, navController = eventNavController)
        }
    }
}

////////////////////////
// CHAT GPT GENERATED //
////////////////////////

@Composable
fun EventScreenMaker(eventNumber: Int, navController: NavHostController) {
    val event = getEventData(eventNumber)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = event.title,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            color = Color.Black // Or specify your own color
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = event.description,
            style = TextStyle(fontSize = 16.sp),
            color = Color.Black // Or specify your own color
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val nextEventNumber = if (eventNumber == 3) 1 else eventNumber + 1
                navController.navigate("event-$nextEventNumber")
            },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Next Event", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (eventNumber != 1) {
            Button(
                onClick = {
                    val prevEventNumber = if (eventNumber == 1) 3 else eventNumber - 1
                    navController.navigate("event-$prevEventNumber")
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Previous Event", color = Color.White)
            }
        }
    }
}

data class Event(
    val title: String,
    val description: String,
)

fun getEventData(eventNumber: Int): Event {
    return when (eventNumber) {
        1 -> Event(
            title = "Event 1: Burrito Ballade",
            description = "Velkommen til Burrito Ballade! Kom og nyd en aften fyldt med lækre burritos, livlig musik og sjove aktiviteter. Tag dine venner med og lad os sammen fejre den mexicanske kultur med god mad og god stemning."
        )
        2 -> Event(
            title = "Event 2: Sommerfest 2024",
            description = "Deltag i Sommerfest 2024 og oplev en dag fyldt med solskin, glæde og fællesskab. Vi byder på grillmad, musikalske optrædener, konkurrencer og meget mere. Så tag din badedragt med og lad os sammen skabe uforglemmelige sommerminder!"
        )
        else -> Event(
            title = "Event 3: Bowling Banden",
            description = "Velkommen til Bowling Banden! Grib dine bowlingsko og tag med til en sjov aften på bowlingbanen. Udfordr dine venner til en duel, nyd lækre snacks og skab uforglemmelige minder. Vi garanterer masser af sjov og latter!"
        )
    }
}

