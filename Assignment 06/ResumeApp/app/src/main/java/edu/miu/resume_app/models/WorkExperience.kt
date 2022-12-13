package edu.miu.resume_app.models

import java.io.Serializable

data class WorkExperience(
    val title: String,
    val position: String,
    val duration: String,
    val image: Int
) : Serializable