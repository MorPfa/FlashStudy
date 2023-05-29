package app.flashstudy.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.flashstudy.data.QuizCard
import app.flashstudy.data.loadDummyData


@Composable
fun QuestionCardListItem(quizCard: QuizCard, modifier: Modifier, highlight: Boolean) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Topic", modifier = Modifier.padding(bottom = 8.dp))
            if (highlight) {
                Text(
                    text = quizCard.question,
                    modifier = Modifier.padding(bottom = 8.dp).background(Color.Yellow)
                )
            } else {
                Text(text = quizCard.question, modifier = Modifier.padding(bottom = 8.dp))
            }
            Text(text = quizCard.answer)
        }
    }
}

@Composable
fun QuestionsScreen() {
    Box(modifier = Modifier.fillMaxWidth()) {
        val quizCards = loadDummyData() // Assuming you have a function that loads the quiz card data
        val highlightedIndex = 2 // Example: Display question with a highlight at index 2

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(quizCards) { index, quizCard ->
                val highlight = index == highlightedIndex
                QuestionCardListItem(quizCard, modifier = Modifier.fillMaxWidth(), highlight = highlight)
            }
        }
    }
}
@Preview
@Composable
fun QuestionsScreenPreview() {
    QuestionsScreen()
}
