package com.beardness.wordknight.di.modules.qualifiers

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoCoroutineScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainCoroutineScope