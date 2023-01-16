package com.demo.android.quiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import com.demo.android.quiz.R
import kotlinx.android.synthetic.main.activity_result_analysis.*

class SolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_analysis)

        val ans = intent.getSerializableExtra(EXTRA_MESSAGE) as ArrayList<String>
        Log.i("all ans:", ans.toString())

        val questions: ArrayList<String> = arrayListOf()

        questions.add(getString(R.string.question_1))
        questions.add(getString(R.string.question_2))
        questions.add(getString(R.string.question_3))
        questions.add(getString(R.string.question_4))
        questions.add(getString(R.string.question_5))
        questions.add(getString(R.string.question_6))
        questions.add(getString(R.string.question_7))
        questions.add(getString(R.string.question_8))
        questions.add(getString(R.string.question_9))
        questions.add(getString(R.string.question_10))
        questions.add(getString(R.string.question_11))
        questions.add(getString(R.string.question_12))
        questions.add(getString(R.string.question_13))
        questions.add(getString(R.string.question_14))
        questions.add(getString(R.string.question_15))

        var i = 1;
        for (question in questions) {
            textView4.append(
                i.toString() +
                        ". " +
                        question +
                        "\nYour answer: " + ans.get(i-1) +
                        "\n\n"
            )
            i++
        }


    }
}