package app.flashstudy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.flashstudy.R
import app.flashstudy.cards.AnimatingBox


@Composable
fun QuizScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        DisplayFlashCards()
    }

}

@Composable
fun DisplayFlashCards() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var rotated by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            AnimatingBox(rotated, modifier = Modifier.fillMaxSize()) { rotated = it }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .widthIn(min = 30.dp)
                        .padding(end = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)



                ) {
                    Text(text = stringResource(R.string.next_card_button), color = MaterialTheme.colors.onPrimary)
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .widthIn(min = 30.dp)
                        .padding(end = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(text = stringResource(R.string.Previous_Card), color = MaterialTheme.colors.onPrimary)
                }
            }

        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview(){
    QuizScreen()
}