package com.beardness.wordknight.presentaion.datasource.words

import android.content.Context
import com.beardness.wordknight.data.wordstype.WordsType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WordsDataSource @Inject constructor(
    private val context: Context
) : IWordsDataSource {
    override suspend fun words(type: WordsType): List<String> {
        return withContext(Dispatchers.IO) {
            val stream = context.assets.open(type.fileName)

            val size = stream.available()

            val buffer = ByteArray(size = size)

            stream.read(buffer)
            stream.close()

            val content = String(bytes = buffer)

            content.split("\n")
        }
    }
}