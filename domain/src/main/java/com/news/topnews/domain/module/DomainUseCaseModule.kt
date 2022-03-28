package com.news.topnews.domain.module

import com.news.topnews.domain.usecase.TopNewsUseCase
import com.news.topnews.domain.usecaseimpl.TopNewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * DI Module class to bind User case interface
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DomainUseCaseModule {
    @Binds
    internal abstract fun bindUseCaseImpl(topNewsUseCaseImpl: TopNewsUseCaseImpl): TopNewsUseCase
}