package com.demo.android.quiz.view

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.android.quiz.R
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {

    lateinit var ans: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val args: (HashMap<String, Any>) = intent.getSerializableExtra(AlarmClock.EXTRA_MESSAGE) as HashMap<String, Any>
        val score = args.get("score") as Int
        val numberOfQuestions = args.get("numOfQs") as Int
        ans = args.get("ans") as ArrayList<String>

        Log.i("anss: ", ans.toString())

        scoreTextView.text = "You scored: " + score.toString() + "/"+ numberOfQuestions.toString()
    }

    fun startAgain(view: View) {
        startActivity(Intent(this, QuestionsActivity::class.java))
    }

    fun backToHome(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun showResultAnalysis(view: View) {
        val intent = Intent(this, SolutionActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, ans)
        }
        startActivity(intent)
    }
}