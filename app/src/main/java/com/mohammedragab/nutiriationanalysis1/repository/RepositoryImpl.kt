package com.mohammedragab.nutiriationanalysis1.repository

import com.mohammedragab.nutiriationanalysis1.model.ModelPostIngradient
import com.mohammedragab.nutiriationanalysis1.model.NutritionData
import com.mohammedragab.nutiriationanalysis1.remotedatalayer.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    ) : Repository {

    override suspend fun getSingleLineNutrition(
        app_id: String,
        app_key: String,
        nutrition_type: String,
        ingr: String
    ): Response<NutritionData> {
        return remoteDataSource.getSingleLineNutrition(app_id,app_key,nutrition_type,ingr)
    }

    override suspend fun getAllNutritionAnalaysis(
        app_id: String,
        app_key: String,
        modelPostIngradient: ModelPostIngradient
    ): Response<NutritionData> {
        return  remoteDataSource.getAllNutritionAnalaysis(app_id,app_key,modelPostIngradient)
    }
}
