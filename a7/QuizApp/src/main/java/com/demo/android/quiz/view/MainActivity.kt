package com.demo.android.quiz.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.android.quiz.R
import com.demo.android.quiz.data.Repository
import com.demo.android.quiz.viewModel.MainViewModel
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { MainViewModel(Repository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.prepopulateQuestions()
    }

    fun startQuiz(view: View) {
        startActivity(Intent(this, QuestionsActivity::class.java))
    }

}
