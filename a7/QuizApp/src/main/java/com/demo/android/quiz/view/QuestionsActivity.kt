package com.demo.android.quiz.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.forEachIndexed
import androidx.lifecycle.Observer
import com.demo.android.quiz.R
import com.demo.android.quiz.data.Repository
import com.demo.android.quiz.data.model.QuizState
import com.demo.android.quiz.viewModel.QuizViewModel
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    private val viewModel by lazy { QuizViewModel(Repository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        getQuestionsAndAnswers()
        lv_block.setViewColor(Color.rgb(239, 88, 150));
        lv_block.setShadowColor(Color.BLACK)
    }

    private fun render(state: QuizState){
        when(state){
            is QuizState.EmptyState -> renderEmptyState()
            is QuizState.DataState -> renderDataState(state)
            is QuizState.FinishState -> goToResultActivity(state.numberOfQuestions, state.score)
            is QuizState.LoadingState -> renderLoadingState()
        }
    }

    private fun renderLoadingState() {
        loading_layout.visibility = View.VISIBLE
        lv_block.startAnim()
    }


    private fun renderDataState(quizState: QuizState.DataState) {
        lv_block.stopAnim()
        loading_layout.visibility = View.GONE
        displayQuestionsView()
        questionsRadioGroup.clearCheck()
        questionTextView.text = quizState.data.question?.text
        questionsRadioGroup.forEachIndexed { index, view ->
            if (index < quizState.data.answers.size)
                (view as RadioButton).text = quizState.data.answers[index].text
        }
    }


    private fun renderEmptyState() {
        empty_layout.visibility = View.VISIBLE
    }


    fun nextQuestion(view: View) {
        val radioButton = findViewById<RadioButton>(questionsRadioGroup.checkedRadioButtonId)
        val selectedOption = questionsRadioGroup.indexOfChild(radioButton)

        if(selectedOption == -1) {
            val toast = Toast.makeText(applicationContext, "Please select an option", Toast.LENGTH_LONG)
            toast.show()
        } else {
            viewModel.nextQuestion(selectedOption)
        }
    }


    private fun displayQuestionsView() {
        question_layout.visibility = View.VISIBLE
    }


    private fun goToResultActivity(numberOfQuestions: Int, score: Int) {

        val params = HashMap<String, Any>()
        params.put("score", score)
        params.put("numOfQs", numberOfQuestions)
        params.put("ans", viewModel.getAns())

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, params)
        }

        startActivity(intent)
    }

    private fun getQuestionsAndAnswers(){
        viewModel.getCurrentState().observe(this, Observer {
            render(it)
        })
    }

}
