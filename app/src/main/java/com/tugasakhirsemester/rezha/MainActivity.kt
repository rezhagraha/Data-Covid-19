package com.tugasakhirsemester.rezha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tugasakhirsemester.rezha.api.RetrofitClient
import com.tugasakhirsemester.rezha.model.indonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowIndonesia()

    }
    private fun ShowIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<indonesiaResponse>>{
            override fun onResponse(
                call: Call<ArrayList<indonesiaResponse>>,
                response: Response<ArrayList<indonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val dirawat = indonesia?.dirawat
                val sembuh = indonesia?.sembuh
                val meninggal = indonesia?.meninggal

                val cassPositive : TextView = findViewById(R.id.tvPositive)
                cassPositive.text= positive
                val cassDirawat : TextView = findViewById(R.id.tvDirawat)
                cassDirawat.text= dirawat
                val cassSembuh : TextView = findViewById(R.id.tvSembuh)
                cassSembuh.text= sembuh
                val cassMeninggal : TextView = findViewById(R.id.tvMeninggal)
                cassMeninggal.text= meninggal

            }
            override fun onFailure(call: Call<ArrayList<indonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}