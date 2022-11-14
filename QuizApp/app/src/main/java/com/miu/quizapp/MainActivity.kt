package com.miu.quizapp
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            var id = q1answ.checkedRadioButtonId
            if (id == R.id.q1o1)
            { // Correct answer
                score += 50
            }

            if (q2o2.isChecked && q2o3.isChecked)
            {
                score += 50
            }

            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)

            val sdf = SimpleDateFormat("dd/mm/yyyy hh:mm")
            val currentDate = sdf.format(Date())

            dialogBuilder.setMessage("Congratulations! You submitted on $currentDate \n You achieved $score%")
                .setCancelable(false)
                .setPositiveButton("Done", DialogInterface.OnClickListener
                {
                        _, _ -> finish()
                })

                .setNegativeButton("Cancel", DialogInterface.OnClickListener
                {
                        dialog, _ ->
                    run {
                        dialog.cancel()
                        this.score = 0
                    }
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Result")
            alert.show()
        }

    }
}