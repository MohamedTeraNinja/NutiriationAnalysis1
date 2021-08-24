package com.mohammedragab.nutiriationanalysis1.di

import com.mohammedragab.nutiriationanalysis1.repository.Repository
import com.mohammedragab.nutiriationanalysis1.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.BinderRepositiory::class])
class RepositoryModule {
     @Module
     interface  BinderRepositiory
     {
          @Binds
          fun repositoryBind(authRepositoryImpl: RepositoryImpl): Repository

     }

}