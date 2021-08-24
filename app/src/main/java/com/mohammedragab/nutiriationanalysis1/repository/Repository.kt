package com.mohammedragab.nutiriationanalysis1.repository

import com.mohammedragab.nutiriationanalysis1.model.ModelPostIngradient
import com.mohammedragab.nutiriationanalysis1.model.NutritionData
import retrofit2.Response

interface Repository {
    suspend fun getSingleLineNutrition(app_id:String
                                       ,app_key:String,
                                       nutrition_type:String,
                                       ingr:String): Response<NutritionData>

    suspend fun getAllNutritionAnalaysis(app_id:String,app_key:String
                                         , modelPostIngradient: ModelPostIngradient
    ): Response<NutritionData>
    //

}