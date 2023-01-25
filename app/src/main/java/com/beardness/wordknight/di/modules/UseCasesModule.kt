package com.beardness.wordknight.di.modules

import com.beardness.wordknight.presentaion.repo.WordsRepo
import com.beardness.wordknight.presentaion.usecases.WordsUseCases
import com.beardness.wordknight.utils.wordsmatcher.WordsMatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideWordsUseCases(
        wordsRepo: WordsRepo,
        wordsMatcher: WordsMatcher,
    ): WordsUseCases =
        WordsUseCases(
            wordsRepo = wordsRepo,
            wordsMatcher = wordsMatcher,
        )
}