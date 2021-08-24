package com.mohammedragab.nutiriationanalysis1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohammedragab.nutiriationanalysis1.presentationlayer.AnalysisViewModel
import com.mohammedragab.nutiriationanalysis1.presentationlayer.ViewModelFactory


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
    @Binds
    @IntoMap
    @ViewModelKey(AnalysisViewModel::class)
    abstract fun bindsAnalysisViewModel(homeVM: AnalysisViewModel): ViewModel



}
