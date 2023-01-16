package com.demo.android.quiz.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.quiz.data.QuestionInfoProvider
import com.demo.android.quiz.data.QuizRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.jetbrains.anko.doAsync

class MainViewModel(private val repository: QuizRepository): ViewModel() {

    private lateinit var  questionInfoProvider: QuestionInfoProvider

    fun prepopulateQuestions() =
        viewModelScope.async {
            questionInfoProvider = QuestionInfoProvider()
            for (question in questionInfoProvider.questionList) {
                repository.saveQuestion(question)
            }
            for (answer in questionInfoProvider.answerList) {
                repository.saveAnswer(answer)
            }
        }

    fun clearQuestions() = viewModelScope.async {
        repository.deleteQuestions()
    }

}