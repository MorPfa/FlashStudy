package app.flashstudy.data

interface CardInfo

data class QuizCard(
    val index : Int,
    val question : String,
    val answer : String,
    val isSelected : Boolean
): CardInfo

fun loadDummyData(): List<QuizCard> {
    val dummyData = listOf(
        QuizCard(1, "What is the capital of France?", "Paris", isSelected = false),
        QuizCard(2, "Who painted the Mona Lisa?", "Leonardo da Vinci", isSelected = false),
        QuizCard(3, "What is the symbol for sodium?", "Na", isSelected = false),
        QuizCard(4, "What is the tallest mountain in the world?", "Mount Everest", isSelected = false),
        QuizCard(5, "What is the formula for water?", "H2O", isSelected = false),
        QuizCard(6, "What is the capital of France?", "Paris", isSelected = false),
        QuizCard(7, "Who painted the Mona Lisa?", "Leonardo da Vinci", isSelected = false),
        QuizCard(8, "What is the symbol for sodium?", "Na", isSelected = false),
        QuizCard(9, "What is the tallest mountain in the world?", "Mount Everest", isSelected = false),
        QuizCard(10, "What is the formula for water?", "H2O", isSelected = false)

    )
    return dummyData
}