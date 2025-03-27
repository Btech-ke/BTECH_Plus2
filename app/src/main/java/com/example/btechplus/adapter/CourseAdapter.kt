package com.example.btechplus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btechplus.R
import com.example.btechplus.model.Course

class CourseAdapter(
    private val courses: List<Course>,
    private val onEnrollClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivCourseIcon: ImageView = view.findViewById(R.id.ivCourseIcon)
        private val tvCourseTitle: TextView = view.findViewById(R.id.tvCourseTitle)
        private val tvCourseDescription: TextView = view.findViewById(R.id.tvCourseDescription)
        private val btnEnroll: Button = view.findViewById(R.id.btnEnroll)

        fun bind(course: Course) {
            ivCourseIcon.setImageResource(course.iconResId)
            tvCourseTitle.text = course.title
            tvCourseDescription.text = course.description
            btnEnroll.setOnClickListener { onEnrollClick(course) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int = courses.size
}



