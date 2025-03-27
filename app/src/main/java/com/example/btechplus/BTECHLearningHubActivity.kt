package com.example.btechplus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btechplus.adapter.CourseAdapter
import com.example.btechplus.model.Course

class BTECHLearningHubActivity : AppCompatActivity() {

    private lateinit var rvCourses: RecyclerView
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var enrollmentLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btech_learning_hub)

        // Initialize activity result launcher for enrollment
        enrollmentLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                // Handle enrollment result if needed
            }
        }

        rvCourses = findViewById(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(this)

        val courses = listOf(
            Course("Computer Packages", "Learn computer basic applications", R.drawable.computer_packages),
            Course("Introduction to Programming", "Learn the basics of programming using Python, Java, C, C++, etc.", R.drawable.ic_programming),
            Course("Web Development", "Build modern web applications using HTML, CSS, and JavaScript.", R.drawable.web),
            Course("Mobile App Development", "Develop mobile applications using Kotlin.", R.drawable.app),
            Course("Ethical Hacking", "Understand penetration testing and cybersecurity.", R.drawable.ethical_hacking),
            Course("Graphic Design", "Learn poster, video, photography, and designing.", R.drawable.graphic),
            Course("Digital Marketing", "Learn SEO, SEM, and social media marketing.", R.drawable.marketing),
            Course("Cybersecurity Basics", "Learn online security fundamentals.", R.drawable.cybersecurity),
            Course("Networking", "Learn online business and networking essentials.", R.drawable.networking)
        )

        courseAdapter = CourseAdapter(courses) { course ->
            val intent = Intent(this, EnrollmentActivity::class.java).apply {
                putExtra("COURSE_TITLE", course.title)
            }
            enrollmentLauncher.launch(intent)
        }

        rvCourses.adapter = courseAdapter
    }
}



