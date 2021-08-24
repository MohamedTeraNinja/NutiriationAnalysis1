package com.mohammedragab.nutiriationanalysis1.remotedatalayer

import com.mohammedragab.nutiriationanalysis1.model.ModelPostIngradient
import com.mohammedragab.nutiriationanalysis1.model.NutritionData
import retrofit2.Response
import retrofit2.http.*


interface RetrofitServices {

    @GET("api/nutrition-data")
    suspend fun getSingleLineNutrition(@Query("app_id")app_id:String
                                       ,@Query("app_key")app_key:String,
                                       @Query("nutrition-type")nutrition_type:String,
                                       @Query("ingr")ingr:String):Response<NutritionData>
    @POST("api/nutrition-details")
    @Headers("Content-Type: application/json","Accept: application/json")
    suspend fun getAllNutritionAnalaysis(@Query("app_id")app_id:String,@Query("app_key")app_key:String
                                         ,@Body testModelNU: ModelPostIngradient):Response<NutritionData>
    //

}