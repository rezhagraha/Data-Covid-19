package com.tugasakhirsemester.rezha.api

import com.tugasakhirsemester.rezha.model.indonesiaResponse
import retrofit2.Call
import retrofit2.http.GET


interface Api {
    @GET ("indonesia")
    fun getIndonesia(): Call<ArrayList<indonesiaResponse>>
}