package pl.meksu.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Sweden",
            "Denmark",
            "Finland",
            "Norway",
            2
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )
        questionsList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )
        questionsList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )
        questionsList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )
        questionsList.add(que10)

        val que11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.ic_flag_of_saudi_arabia,
            "Saudi Arabia",
            "Qatar",
            "Iraq",
            "Nigeria",
            1
        )
        questionsList.add(que11)

        val que12 = Question(
            12, "What country does this flag belong to?",
            R.drawable.ic_flag_of_madagascar,
            "Yemen",
            "Madagascar",
            "Sudan",
            "Benin",
            2
        )
        questionsList.add(que12)

        val que13 = Question(
            13, "What country does this flag belong to?",
            R.drawable.ic_flag_of_italy,
            "France",
            "Ireland",
            "Italy",
            "Iceland",
            4
        )
        questionsList.add(que13)

        val que14 = Question(
            14, "What country does this flag belong to?",
            R.drawable.ic_flag_of_poland,
            "Indonesia",
            "Monaco",
            "Singapore",
            "Poland",
            4
        )
        questionsList.add(que14)

        questionsList.shuffle()

        return questionsList
    }
}