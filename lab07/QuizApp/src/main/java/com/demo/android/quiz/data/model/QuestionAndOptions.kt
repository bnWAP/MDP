package com.demo.android.quiz.data.model

import androidx.room.Embedded
import androidx.room.Relation

class QuestionAndOptions {
    @Embedded
    var question: Question? = null

    @Relation(parentColumn = "question_id",
        entityColumn = "question_id")
    var answers: List<Options> = ArrayList()
}