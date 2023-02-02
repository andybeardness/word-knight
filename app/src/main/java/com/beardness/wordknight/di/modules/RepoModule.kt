package com.beardness.wordknight.di.modules

import com.beardness.wordknight.presentaion.datasource.words.IWordsDataSource
import com.beardness.wordknight.presentaion.repo.words.IWordsRepo
import com.beardness.wordknight.presentaion.repo.words.WordsRepo
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
        wordsDataSource: IWordsDataSource,
    ): IWordsRepo =
        WordsRepo(
            wordsDataSource = wordsDataSource
        )
}