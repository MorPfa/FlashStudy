package app.flashstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import app.flashstudy.navigation.BottomNavBar
import app.flashstudy.navigation.BottomNavItem
import app.flashstudy.navigation.Navigation
import app.flashstudy.screens.DisplayFlashCards
import app.flashstudy.ui.theme.FlashStudyTheme


class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashStudyTheme {

                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(
                                items = listOf(
                                    BottomNavItem(
                                        name = "Quiz",
                                        route = "Quiz",
                                        icon = R.drawable.nav_icon_quiz
                                    ),
                                    BottomNavItem(
                                        name = "Questions",
                                        route = "Questions",
                                        icon = R.drawable.nav_icon_question,
                                        badgeCount = 23
                                    ),
                                    BottomNavItem(
                                        name = "Topics",
                                        route = "Topics",
                                        icon = R.drawable.nav_icon_topic,
                                        badgeCount = 214
                                    ),
                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }



@Composable
fun FlashStudyApp(modifier: Modifier){
    DisplayFlashCards()
}



@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen(){
    FlashStudyApp(modifier = Modifier)
}