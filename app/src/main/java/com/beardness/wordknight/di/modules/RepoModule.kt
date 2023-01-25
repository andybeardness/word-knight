package com.beardness.wordknight.di.modules

import com.beardness.wordknight.presentaion.datasource.WordsDataSource
import com.beardness.wordknight.presentaion.repo.WordsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideWordsRepo(
        wordsDataSource: WordsDataSource,
    ): WordsRepo =
        WordsRepo(
            wordsDataSource = wordsDataSource
        )
}