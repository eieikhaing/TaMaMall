package com.kinetichub.tamamall.repository

import com.kinetichub.tamamall.remote.RemoteDataSource
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
)  {
    val remote = remoteDataSource
}