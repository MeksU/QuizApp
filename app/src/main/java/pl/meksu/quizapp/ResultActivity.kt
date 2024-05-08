package pl.meksu.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_congratulations)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        val name: String? = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        tvName.text = "Congratulations, $name!"
        tvScore.text = "Your score is $correctAnswers out of $totalQuestions!"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}