package com.beardness.wordknight.di.modules

import com.beardness.wordknight.presentaion.repo.words.IWordsRepo
import com.beardness.wordknight.presentaion.usecases.device.DeviceUseCases
import com.beardness.wordknight.presentaion.usecases.device.IDeviceUseCases
import com.beardness.wordknight.presentaion.usecases.words.IWordsUseCases
import com.beardness.wordknight.presentaion.usecases.words.WordsUseCases
import com.beardness.wordknight.utils.wordsmatcher.IWordsMatcher
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
        wordsRepo: IWordsRepo,
        wordsMatcher: IWordsMatcher,
    ): IWordsUseCases =
        WordsUseCases(
            wordsRepo = wordsRepo,
            wordsMatcher = wordsMatcher,
        )

    @Provides
    @Singleton
    fun provideDeviceUseCases(): IDeviceUseCases =
        DeviceUseCases()
}