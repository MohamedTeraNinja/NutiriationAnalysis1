package com.mohammedragab.nutiriationanalysis1.presentationlayer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mohammedragab.nutiriationanalysis1.model.ErrorMessage
import com.mohammedragab.nutiriationanalysis1.model.ModelPostIngradient
import com.mohammedragab.nutiriationanalysis1.model.NutritionData
import com.mohammedragab.nutiriationanalysis1.repository.Repository
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

import javax.inject.Inject

class AnalysisViewModel @Inject constructor(private val homeRepository: Repository) :ViewModel() {
    //  check for response loading
    private val _loading = SingleLiveEvent<Boolean>()
    val loading: SingleLiveEvent<Boolean>
        get() = _loading

    // for check  get message error and print response value
    private val _responseErrorMessage = SingleLiveEvent<String>()
    val responseErrorMessage: SingleLiveEvent<String>
        get() = _responseErrorMessage
    //
    private val _nutritionData = MutableLiveData<NutritionData>()
    val nutritionData: LiveData<NutritionData>
        get() = _nutritionData

    fun  getSingleLineNutrition(app_id: String,
                                        app_key: String,
                                        nutrition_type: String,
                                        ingr: String){
        _loading.value=true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val baseResponse=homeRepository.getSingleLineNutrition(app_id,
                app_key,nutrition_type,ingr)
                if (baseResponse.isSuccessful) {
                    val authResponse1=baseResponse.body()
                    withContext(Dispatchers.Main) {
                        _loading.value = false
                        _nutritionData.value = authResponse1
                    }
                }else{
                    withContext(Dispatchers.Main) {
                        _loading.value = false
                        var gson = Gson()
                        var eventResponse = gson.fromJson(
                            baseResponse.errorBody()!!.string(),
                            ErrorMessage::class.java
                        )

                        _responseErrorMessage.value = eventResponse.error
                    }

                }
            }catch (ex: Exception){
                withContext(Dispatchers.Main) {
                    _loading.value = false
                    _responseErrorMessage.value = ex.localizedMessage
                }

            }


        }
    }
    //......... for all line and ingradient
    fun  getAllLineNutrition(app_id:String,app_key:String
                             , modelPostIngradient: ModelPostIngradient
    ){
        _loading.value=true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val baseResponse=homeRepository.getAllNutritionAnalaysis(app_id,
                    app_key,modelPostIngradient)
                if (baseResponse.isSuccessful) {
                    val authResponse1=baseResponse.body()

                    withContext(Dispatchers.Main){
                        _loading.value = false
                        _nutritionData.value=authResponse1
                    }

                }else{
                    withContext(Dispatchers.Main) {
                        _loading.value = false
                        var gson = Gson()
                        var eventResponse = gson.fromJson(
                            baseResponse.errorBody()!!.string(),
                            ErrorMessage::class.java
                        )

                        _responseErrorMessage.value = eventResponse.error
                    }

                }
            }catch (ex: Exception){
                withContext(Dispatchers.Main) {
                    _loading.value = false
                    _responseErrorMessage.value = ex.localizedMessage
                }

            }


        }
    }




}