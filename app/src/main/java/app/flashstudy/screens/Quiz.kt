package app.flashstudy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, start = 20.dp)
            ) {
                Box(contentAlignment = Alignment.TopStart) { // Add Box for "Create quiz" button
                    Button(
                        onClick = { /*TODO*/ },

                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                    ) {
                        Text(text = "Create quiz", color = MaterialTheme.colors.onPrimary)
                    }
                }
                Box(contentAlignment = Alignment.TopEnd) { // Add Box for "Edit quiz" button
                    Button(
                        onClick = { /*TODO*/ },

                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                    ) {
                        Text(text = "Edit quiz", color = MaterialTheme.colors.onPrimary)
                    }
                }
            }

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
                        .padding(start = 10.dp),
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