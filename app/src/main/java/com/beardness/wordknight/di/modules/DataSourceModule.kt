package com.beardness.wordknight.di.modules

import android.content.Context
import com.beardness.wordknight.presentaion.datasource.words.WordsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideWordsDataSource(
        @ApplicationContext context: Context
    ): WordsDataSource =
        WordsDataSource(
            context = context,
        )
}