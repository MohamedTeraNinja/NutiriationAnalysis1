package com.mohammedragab.nutiriationanalysis1.remotedatalayer

import com.mohammedragab.nutiriationanalysis1.model.ModelPostIngradient
import com.mohammedragab.nutiriationanalysis1.model.NutritionData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(val retrofiServices: RetrofitServices) :
    RemoteDataSource {
    override suspend fun getSingleLineNutrition(
        app_id: String,
        app_key: String,
        nutrition_type: String,
        ingr: String
    ): Response<NutritionData> {
        return  retrofiServices.getSingleLineNutrition(app_id,app_key,nutrition_type,ingr)
    }

    override suspend fun getAllNutritionAnalaysis(
        app_id: String,
        app_key: String,
        mdelPostIngradient: ModelPostIngradient
    ): Response<NutritionData> {
       return  retrofiServices.getAllNutritionAnalaysis(app_id,app_key,mdelPostIngradient)
    }
}
