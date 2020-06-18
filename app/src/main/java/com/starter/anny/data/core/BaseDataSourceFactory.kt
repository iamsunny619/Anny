package com.starter.anny.data.core

abstract class BaseDataSourceFactory<T> {
    abstract val localDataSource: T
    abstract val remoteDataSource: T
}