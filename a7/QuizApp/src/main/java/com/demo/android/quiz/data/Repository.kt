package com.demo.android.quiz.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.demo.android.quiz.QuizApplication
import com.demo.android.quiz.data.db.QuizDao
import com.demo.android.quiz.data.model.Options
import com.demo.android.quiz.data.model.Question
import com.demo.android.quiz.data.model.QuestionAndOptions

class Repository : QuizRepository {

    private val quizDao: QuizDao by lazy {
        QuizApplication.database.quizDao()
    }
    private val allQuestions by lazy { quizDao.getAllQuestions() }
    private val allQuestionsAndAllAnswers by lazy {
        quizDao.getQuestionAndAllAnswers() }

    override fun getSavedQuestions(): LiveData<List<Question>> {
        return allQuestions
    }

    override suspend fun saveQuestion(question: Question) {
        quizDao.insert(question)
    }

    override suspend fun saveAnswer(answer: Options) {
        quizDao.insert(answer)
    }

    override fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndOptions>> {
        return allQuestionsAndAllAnswers
    }

    override suspend fun deleteQuestions() {
        AsyncTask.execute { quizDao.clearQuestions() }
    }
}