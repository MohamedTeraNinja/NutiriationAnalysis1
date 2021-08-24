package com.mohammedragab.nutiriationanalysis1.di

import com.mohammedragab.nutiriationanalysis1.MainActivity
import com.mohammedragab.nutiriationanalysis1.analysisdata.AddDataNutritionAnalysisFragment
import com.mohammedragab.nutiriationanalysis1.analysisdata.HistoryDataNutritionAnalysisFragment
import com.mohammedragab.nutiriationanalysis1.analysisdata.TotalCalculationNutritionAnalysisFragment

import dagger.Subcomponent

@Subcomponent
interface AnalysisComponent {
    // Factory to create instances of AuthComponent

    @Subcomponent.Factory
     interface Factory{
        fun  create():AnalysisComponent
    }

    fun  inject(mainActivity: MainActivity)
    fun  inject(addDataNutritionAnalysisFragment: AddDataNutritionAnalysisFragment)
    fun  inject(historyDataNutritionAnalysisFragment: HistoryDataNutritionAnalysisFragment)
    fun inject(totalCalculationNutritionAnalysisFragment: TotalCalculationNutritionAnalysisFragment)
}
