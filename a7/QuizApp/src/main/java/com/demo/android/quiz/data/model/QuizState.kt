package com.demo.android.quiz.data.model

sealed class QuizState {

    object LoadingState : QuizState()
    data class DataState(val data: QuestionAndOptions): QuizState()
    object EmptyState : QuizState()
    data class FinishState(val numberOfQuestions: Int, val score: Int) : QuizState()

}