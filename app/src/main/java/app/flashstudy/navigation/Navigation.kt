package app.flashstudy.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import app.flashstudy.QuestionsScreen
import app.flashstudy.screens.QuizScreen
import app.flashstudy.TopicsScreen
import app.flashstudy.R


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Quiz") {
        composable("Quiz") {
            QuizScreen()
        }
        composable("Questions") {
            QuestionsScreen()
        }
        composable("Topics") {
            TopicsScreen()
        }
    }
}

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Blue,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.nav_icon_topic),
                            contentDescription = item.name
                                )

                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                            )

                    }
                }
            )
        }
    }
}