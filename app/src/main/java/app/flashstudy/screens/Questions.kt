package app.flashstudy.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.flashstudy.data.QuizCard
import app.flashstudy.data.loadDummyData


@Composable
fun QuestionsScreen(modifier: Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)) {
        val quizCards = loadDummyData()
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(quizCards) { index, quizCard ->
                QuestionCard(quizCard, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}


@Composable
fun QuestionCard(quizCard: QuizCard, modifier: Modifier) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp),
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Topic",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start
                )
            }

            Text(
                text = quizCard.question,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = quizCard.answer)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun QuestionsScreenPreview() {
    QuestionsScreen(modifier = Modifier)
}

@Preview(showSystemUi = true)
@Composable
fun QuestionCardPreview(){
    QuestionCard(quizCard = loadDummyData()[0], modifier = Modifier)
}
