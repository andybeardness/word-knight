package com.beardness.wordknight.di.modules

import com.beardness.wordknight.utils.wordsmatcher.IWordsMatcher
import com.beardness.wordknight.utils.wordsmatcher.WordsMatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Provides
    @Singleton
    fun provideWordsMatcher(): IWordsMatcher =
        WordsMatcher()

}