package com.demo.android.quiz.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.demo.android.quiz.data.model.Options
import com.demo.android.quiz.data.model.Question
import com.demo.android.quiz.data.model.QuestionAndOptions

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(options: Options)

    @Query("DELETE FROM questions")
    fun clearQuestions()

    @Delete
    fun deleteQuestion(question: Question)

    @Query("SELECT * FROM questions ORDER BY question_id")
    fun getAllQuestions(): LiveData<List<Question>>

    @Transaction
    @Query("SELECT * FROM questions")
    fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndOptions>>
}