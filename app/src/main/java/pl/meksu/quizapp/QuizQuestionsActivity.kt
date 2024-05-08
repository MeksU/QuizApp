package pl.meksu.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0
    private var isOptionClicked: Boolean = false

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView?= null
    private var ivImage: ImageView? = null
    private var optionA: TextView? = null
    private var optionB: TextView? = null
    private var optionC: TextView? = null
    private var optionD: TextView? = null
    private var btnSubmit: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.pb_progress)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        optionA = findViewById(R.id.tv_option_a)
        optionB = findViewById(R.id.tv_option_b)
        optionC = findViewById(R.id.tv_option_c)
        optionD = findViewById(R.id.tv_option_d)
        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        optionA?.text = question.optionA
        optionB?.text = question.optionB
        optionC?.text = question.optionC
        optionD?.text = question.optionD

        optionA?.setOnClickListener(this)
        optionB?.setOnClickListener(this)
        optionC?.setOnClickListener(this)
        optionD?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        if(mCurrentPosition != mQuestionsList!!.size) {
            btnSubmit?.text = "SUBMIT"
        } else {
            btnSubmit?.text = "FINISH"
        }
    }

    private fun defaultOptionsView() {
        val options: ArrayList<TextView> = ArrayList()
        optionA?.let {
            options.add(0, it)
        }
        optionB?.let {
            options.add(1, it)
        }
        optionC?.let {
            options.add(2, it)
        }
        optionD?.let {
            options.add(3, it)
        }

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_option_a -> {
                optionA?.let {
                    selectedOptionView(it, 1)
                }
                isOptionClicked = true
            }
            R.id.tv_option_b -> {
                optionB?.let {
                    selectedOptionView(it, 2)
                }
                isOptionClicked = true
            }
            R.id.tv_option_c -> {
                optionC?.let {
                    selectedOptionView(it, 3)
                }
                isOptionClicked = true
            }
            R.id.tv_option_d -> {
                optionD?.let {
                    selectedOptionView(it, 4)
                }
                isOptionClicked = true
            }
            R.id.btn_submit -> {
                if(!isOptionClicked) {
                    Toast.makeText(
                        this,
                        "Please select an option!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(mSelectedOption == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                            isOptionClicked = false
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if(question!!.correctAnswer != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    
                    if(mCurrentPosition != mQuestionsList!!.size) {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    else {
                        btnSubmit?.text = "FINISH"
                    }
                    mSelectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                optionA?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionB?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionC?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionD?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}