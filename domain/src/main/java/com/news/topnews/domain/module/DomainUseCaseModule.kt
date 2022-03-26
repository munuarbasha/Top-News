package com.news.topnews.domain.module

import com.news.topnews.domain.usecase.TopNewsUseCase
import com.news.topnews.domain.usecase.TopNewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainUseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindUseCaseImpl(topNewsUseCaseImpl: TopNewsUseCaseImpl): TopNewsUseCase
}