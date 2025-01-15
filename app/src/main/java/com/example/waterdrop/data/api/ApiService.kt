package com.example.waterdrop.data.api

import com.example.waterdrop.data.dto.GoodsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("newmobile/glavnaya/super_top.php?action=topglav")
    suspend fun getGoods(): GoodsResponse
}