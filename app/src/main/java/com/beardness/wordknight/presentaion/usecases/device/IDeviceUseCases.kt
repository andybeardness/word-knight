package com.beardness.wordknight.presentaion.usecases.device

import kotlinx.coroutines.flow.StateFlow

interface IDeviceUseCases {
    val copyToClipboard: StateFlow<String?>

    suspend fun copyToClipboard(value: String)
}