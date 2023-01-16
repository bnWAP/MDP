package com.demo.android.quiz.data

import com.demo.android.quiz.data.model.Options
import com.demo.android.quiz.data.model.Question

class QuestionInfoProvider {

    var questionList = initQuestionList()
    var answerList = initAnswersList()

    private fun initQuestionList(): MutableList<Question>{
        val questions = mutableListOf<Question>()
        questions.add(
            Question(1, "1. What is the UI building block of an Android app?")
        )
        questions.add(
            Question(2, "2. What is an Intent in Android?")
        )
        questions.add(
            Question(3, "3. What is the difference between a Service and a Thread in Android?")
        )
        questions.add(
            Question(4, "4. What is the difference between an Activity and a Fragment in Android?")
        )
        questions.add(
            Question(5, "5. How can you store data in Android?")
        )
        questions.add(
            Question(6, "6. What is the purpose of the AndroidManifest.xml file?")
        )
        questions.add(
            Question(7, "7. What is the Android SDK?")
        )
        questions.add(
            Question(8, "8. How can you handle user input in Android?")
        )
        questions.add(
            Question(9, "9. How can you communicate between different components in Android?")
        )
        questions.add(
            Question(10, "10. What is an AsyncTask in Android?")
        )
        questions.add(
            Question(11, "11. What is the Android Support Library?")
        )
        questions.add(
            Question(12, "12. What is the Android Gradle plugin?")
        )
        questions.add(
            Question(13, "13. What is the Android NDK?")
        )
        questions.add(
            Question(14, "14. What is the Android Emulator?")
        )
        questions.add(
            Question(15, "15. What is the Android XML layout file?")
        )
        return questions
    }

    private fun initAnswersList(): MutableList<Options>{
        val answers = mutableListOf<Options>()

        answers.add(Options(1, 1, true, "A. Activity"))
        answers.add(Options(2, 1, false, "B. Service"))
        answers.add(Options(3, 1, false, "C. Broadcast Receiver"))
        answers.add(Options(4, 1, false, "D. Content Provider"))

        answers.add(Options(5, 2, true, "A. A message object that is used to communicate between components"))
        answers.add(Options(6, 2, false, "B. A UI element that displays text or images"))
        answers.add(Options(7, 2, false, "C. A mechanism for managing app permissions"))
        answers.add(Options(8, 2, false, "D. A method for storing app data"))

        answers.add(Options(9, 3, true, "A. A Service runs in the background, while a Thread runs on the UI thread"))
        answers.add(Options(10, 3, false, "B. A Service can be bound to by other components, while a Thread cannot"))
        answers.add(Options(11, 3, false, "C. A Thread can run indefinitely, while a Service must stop after a certain period of time"))
        answers.add(Options(12, 3, false, "D. A Service can access the Internet, while a Thread cannot"))

        answers.add(Options(13, 4, true, "A. An Activity represents a single screen, while a Fragment represents a portion of a screen"))
        answers.add(Options(14, 4, false, "B. An Activity can be used across multiple apps, while a Fragment is specific to one app"))
        answers.add(Options(15, 4, false, "C. An Activity can display UI elements, while a Fragment cannot"))
        answers.add(Options(16, 4, false, "D. A Fragment can be added or removed dynamically, while an Activity cannot"))

        answers.add(Options(17, 5, false, "A. SharedPreferences"))
        answers.add(Options(18, 5, false, "B. SQLite Database"))
        answers.add(Options(19, 5, false, "C. External storage"))
        answers.add(Options(20, 5, true, "D. All of the above"))

        answers.add(Options(21, 6, false, "A. To define the layout of the app"))
        answers.add(Options(22, 6,true, "B. To define the app's components and permissions"))
        answers.add(Options(23, 6, false, "C. To define the app's theme and style"))
        answers.add(Options(24, 6, false, "D. To define the app's target API level"))

        answers.add(Options(25, 7, true, "A. A set of tools and resources for building Android apps"))
        answers.add(Options(26, 7, false, "B. A virtual device for running and testing Android apps"))
        answers.add(Options(27, 7, false, "C. A marketplace for distributing Android apps"))
        answers.add(Options(28, 7, false, "D. A programming language for developing Android apps"))

        answers.add(Options(29, 8, false, "A. Buttons and click listeners"))
        answers.add(Options(30, 8, false, "B. Text fields and text watchers"))
        answers.add(Options(31, 8, false, "C. Touch events and gesture detectors"))
        answers.add(Options(32, 8, true, "D. All of the above"))

        answers.add(Options(33, 9, false, "A. Intents"))
        answers.add(Options(34, 9, false, " B. Broadcasts"))
        answers.add(Options(35, 9, false, "C. Services"))
        answers.add(Options(36, 9, true, "D. All of the above"))

        answers.add(Options(37, 10, true, "A. A mechanism for running tasks in the background"))
        answers.add(Options(38, 10, false, "B. A mechanism for scheduling tasks to run at a later time"))
        answers.add(Options(39, 10, false, "C. A mechanism for sharing data between different apps"))
        answers.add(Options(40, 10, false, "D. A mechanism for handling user input"))

        answers.add(Options(41, 11, true, "A. A set of libraries for adding new features to older versions of Android"))
        answers.add(Options(42, 11, false, "B. A set of libraries for creating custom UI elements"))
        answers.add(Options(43, 11, false, "C. A set of libraries for interacting with external devices"))
        answers.add(Options(44, 11, false, "D. A set of libraries for improving app performance"))

        answers.add(Options(45, 12, true, "A. A set of tools for building and deploying Android apps"))
        answers.add(Options(46, 12, false, "B. A set of tools for testing Android apps"))
        answers.add(Options(47, 12, false, "C. A set of tools for debugging Android apps"))
        answers.add(Options(48, 12, false, "D. A set of tools for creating custom UI elements"))

        answers.add(Options(49, 13, true, "A. A set of tools for developing native code for Android"))
        answers.add(Options(50, 13, false, "B. A set of libraries for developing Android apps in C++"))
        answers.add(Options(51, 13, false, "C. A set of tools for debugging Android apps"))
        answers.add(Options(52, 13, false, "D. A set of tools for creating custom UI elements"))

        answers.add(Options(53, 14, true, "A. A virtual device for running and testing Android apps"))
        answers.add(Options(54, 14, false, "B. A set of tools for debugging Android apps"))
        answers.add(Options(55, 14, false, "C. A set of libraries for developing Android apps in C++"))
        answers.add(Options(56, 14, false, "D. A tool for creating custom UI elements"))

        answers.add(Options(57, 15, true, "A. A file containing the layout and UI elements of an activity"))
        answers.add(Options(58, 15, false, "B. A file containing the resources used by an app"))
        answers.add(Options(59, 15, false, "C. A file containing the app's code"))
        answers.add(Options(60, 15, false, "D. A file containing the app's permissions"))

        return answers
    }

}