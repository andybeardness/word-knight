package com.beardness.wordknight.presentaion.usecases.device

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class DeviceUseCases @Inject constructor() : IDeviceUseCases {
    private val _copyToClipboard = MutableStateFlow<String?>(value = null)
    override val copyToClipboard = _copyToClipboard.asStateFlow()

    override suspend fun copyToClipboard(value: String) {
        _copyToClipboard.emit(value = value)
    }
}