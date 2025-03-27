package com.example.btechplus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EnrollmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enrollment)

        val tvCourseTitle = findViewById<TextView>(R.id.tvCourseTitle)
        val btnConfirmEnroll = findViewById<Button>(R.id.btnConfirmEnroll)

        // Get course title from intent
        val courseTitle = intent.getStringExtra("COURSE_TITLE")
        tvCourseTitle.text = courseTitle ?: "Unknown Course"

        btnConfirmEnroll.setOnClickListener {
            // Return success result after user confirms enrollment
            val resultIntent = Intent()
            resultIntent.putExtra("ENROLLMENT_STATUS", "Success")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

