package com.mado.ap_recipeapp
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}
