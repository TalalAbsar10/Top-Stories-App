package com.example.egym.topstories.data.repository

import com.example.egym.BuildConfig
import com.example.egym.topstories.data.data_source.TopStoriesApi
import com.example.egym.topstories.data.data_source.database.TopStoriesDetailsDao
import com.example.egym.topstories.domain.model.TopStoriesDetails
import com.example.egym.topstories.domain.repository.TopStoriesDetailsRepository
import com.example.egym.topstories.util.Constants
import com.example.egym.topstories.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class TopStoriesDetailsRepositoryImpl(
    private val api: TopStoriesApi,
    private val dao: TopStoriesDetailsDao
) : TopStoriesDetailsRepository {
    var topStoriesDetails: TopStoriesDetails? = null
    override fun getTopStoriesDetails(section: String): Flow<Resource<TopStoriesDetails>> = flow {
        emit(Resource.Loading())

        try {
            val remoteTopStoriesDetails = api.getTopStoriesDetails(section, BuildConfig.API_KEY)
            dao.insertTopStoriesDetails(remoteTopStoriesDetails.toTopStoriesDetails())
            topStoriesDetails = dao.getTopStoriesDetails(section).toTopStoriesDetails()
            emit(Resource.Loading(data = topStoriesDetails))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = Constants.SOMETHING_WENT_WRONG,
                    data = topStoriesDetails
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = Constants.NO_INTERNET_CONNECTION,
                    data = topStoriesDetails
                )
            )
        }
        emit(Resource.Success(data = topStoriesDetails))
    }

}