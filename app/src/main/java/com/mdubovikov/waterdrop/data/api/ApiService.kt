package com.mdubovikov.waterdrop.data.api

import com.mdubovikov.waterdrop.data.dto.GoodsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("newmobile/glavnaya/super_top.php?action=topglav")
    suspend fun getGoods(): GoodsResponse
}