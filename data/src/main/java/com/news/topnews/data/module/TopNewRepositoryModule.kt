package com.news.topnews.data.module

import com.news.topnews.data.repository.TopNewsRepositoryImpl
import com.news.topnews.domain.repository.TopNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TopNewRepositoryModule {

    @Binds
    internal abstract fun bindRepository(repositoryImpl: TopNewsRepositoryImpl): TopNewsRepository
}