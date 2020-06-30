package com.starter.anny.di.modules

import dagger.Module

@Module(
    includes = [DataRepositoryModule::class,
        ShopAndPickUpModule::class,
        TmdbModule::class]
)
interface DataModule