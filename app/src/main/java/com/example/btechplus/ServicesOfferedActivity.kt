package com.example.btechplus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btechplus.adapter.ServiceAdapter
import com.example.btechplus.model.Service

class ServicesOfferedActivity : AppCompatActivity() {

    private lateinit var recyclerViewServices: RecyclerView
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_offered)

        recyclerViewServices = findViewById(R.id.recyclerViewServices)
        recyclerViewServices.layoutManager = LinearLayoutManager(this)

        // List of Services
        val serviceList = listOf(
            Service("BTECH Computer Learning Hub", "IT training courses", R.drawable.tech_learning),
            Service("Online Cyber Services", "KUCCPS, HELB, KRA, eCitizen, NTSA, NHIF & more", R.drawable.online_cyber),
            Service("Tech Repair & Maintenance", "Computer, phone, printer repairs, data recovery", R.drawable.repair),
            Service("Digital Business Solutions", "Website development, branding, automation", R.drawable.business),
            Service("Tech Accessories & Sales", "Laptops, smartphones, gaming accessories, smart home devices", R.drawable.sales)
        )

        // Adapter for Services
        serviceAdapter = ServiceAdapter(serviceList) { service ->
            val intent = when (service.name) {
                "BTECH Computer Learning Hub" -> Intent(this, BTECHLearningHubActivity::class.java)
                "Online Cyber Services" -> Intent(this, OnlineCyberServicesActivity::class.java)
                "Tech Repair & Maintenance" -> Intent(this, TechRepairActivity::class.java)
                "Digital Business Solutions" -> Intent(this, DigitalBusinessActivity::class.java)
                "Tech Accessories & Sales" -> Intent(this, TechAccessoriesActivity::class.java)
                else -> null
            }
            intent?.let { startActivity(it) }
        }

        recyclerViewServices.adapter = serviceAdapter
    }
}



