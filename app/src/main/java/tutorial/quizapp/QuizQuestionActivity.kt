package tutorial.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var questionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0
    private var userName : String? = null
    private var correctAnswerCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        questionsList = Constants.getQuestions()
        exhibitQuestion()
        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        btn_Submit.setOnClickListener(this)
        userName = intent.getStringExtra(Constants.USER_NAME)

    }

    private fun exhibitQuestion() {
        val question = questionsList!![currentPosition - 1]
        pg_progress.progress = currentPosition
        tv_progress.text = "$currentPosition/${pg_progress.max}"
        question_tv.text = question.question
        iv_Image.setImageResource(question.image)
        tv_option1.text = question.optionOne
        tv_option2.text = question.optionTwo
        tv_option3.text = question.optionThree
        tv_option4.text = question.optionFour
        if (currentPosition == questionsList!!.size) {
            btn_Submit.text = "FINISH"
        }
        else{
            btn_Submit.text = "SKIP"
        }
        defaultOptionsView()
    }

    private fun defaultOptionsView() {
        val options = arrayListOf(tv_option1, tv_option2, tv_option3, tv_option4)
        options.forEach {
            it.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.text_color
                )
            )
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun changeSelectedOption(tv: TextView, selectedOption: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option1 -> {
                changeSelectedOption(tv_option1, 1)
                btn_Submit.text = "SUBMIT"
            }
            R.id.tv_option2 -> {
                changeSelectedOption(tv_option2, 2)
                btn_Submit.text = "SUBMIT"
            }
            R.id.tv_option3 -> {
                changeSelectedOption(tv_option3, 3)
                btn_Submit.text = "SUBMIT"
            }
            R.id.tv_option4 -> {
                changeSelectedOption(tv_option4, 4)
                btn_Submit.text = "SUBMIT"
            }
            R.id.btn_Submit -> {
                if (mSelectedOptionPosition == 0){
                    currentPosition++
                    if (currentPosition <= questionsList!!.size) {exhibitQuestion()}
                    else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, userName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
                        intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswerCounter)
                        startActivity(intent)
                        finish()

                    }
                }
                else{
                    val question = questionsList!![currentPosition -1]
                    if (question.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        correctAnswerCounter++
                    }

                    answerView(question.correctAns, R.drawable.correct_option_border_bg)
                    if (currentPosition == questionsList!!.size){
                        btn_Submit.text = "FINISH"
                    }
                    else btn_Submit.text = "GO TO NEXT QUESTION"
                    mSelectedOptionPosition = 0
                }
            }
        }
    }


    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                tv_option1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tv_option2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tv_option3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tv_option4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}