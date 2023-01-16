package com.demo.android.quiz.data

import androidx.lifecycle.LiveData
import com.demo.android.quiz.data.model.Options
import com.demo.android.quiz.data.model.Question
import com.demo.android.quiz.data.model.QuestionAndOptions

interface QuizRepository {
    fun getSavedQuestions(): LiveData<List<Question>>

    suspend fun saveQuestion(question: Question)

    suspend fun saveAnswer(answer: Options)

    fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndOptions>>

    suspend fun deleteQuestions()
}