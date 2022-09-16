package tutorial.quizapp

object Constants {
    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val question1 = Question(
              1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina, "USA", "UK", "Argentina",
            "Armenia",3
        )
        questionList.add(question1)
        val question2 = Question(
            2,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_australia, "Scotland", "Australia", "Austria",
            "New Zealand",2
        )
        questionList.add(question2)
        val question3 = Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium, "Belgium", "India", "Germany",
            "Italy",1
        )
        questionList.add(question3)
        val question4 = Question(
            4,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_germany, "France", "Slovenia", "Germany",
            "Austria",3
        )
        questionList.add(question4)
        val question5 = Question(
            5,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand, "Australia", "Haiti", "Israel",
            "New Zealand",4
        )
        questionList.add(question5)
        val question6 = Question(
            6,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_india, "China", "India", "Laos",
            "Vietnam",2
        )
        questionList.add(question6)
        val question7 = Question(
            7,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil, "Brazil", "Congo", "Guatamala",
            "Chile",1
        )
        questionList.add(question7)
        val question8 = Question(
            8,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait, "Palestine", "Kuwait",
            "United Arab Emarites", "Jordan",2
        )
        questionList.add(question8)
        val question9 = Question(
            9,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji, "Tahiti", "Samoa", "Hungary",
            "Fiji",4
        )
        questionList.add(question9)
        val question10 = Question(
            10,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark, "Norway", "Sweden", "Denmark",
            "Finland",3
        )
        questionList.add(question10)
        return questionList
    }
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "Total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"
}