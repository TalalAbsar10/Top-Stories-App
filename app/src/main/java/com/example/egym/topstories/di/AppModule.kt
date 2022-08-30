package com.example.egym.topstories.di

import android.app.Application
import androidx.room.Room
import com.example.egym.topstories.data.data_source.TopStoriesApi
import com.example.egym.topstories.data.data_source.database.Converters
import com.example.egym.topstories.data.data_source.database.TopStoriesDetailsDatabase
import com.example.egym.topstories.data.repository.TopStoriesDetailsRepositoryImpl
import com.example.egym.topstories.domain.repository.TopStoriesDetailsRepository
import com.example.egym.topstories.domain.use_case.get_top_stories_sections.GetTopStoriesSectionsUseCase
import com.example.egym.topstories.util.Constants
import com.example.egym.topstories.util.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideTopStoriesApi(): TopStoriesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TopStoriesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTopStoriesRepository(
        api: TopStoriesApi,
        db: TopStoriesDetailsDatabase
    ): TopStoriesDetailsRepository {
        return TopStoriesDetailsRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideTopStoriesDatabase(app: Application): TopStoriesDetailsDatabase {
        return Room.databaseBuilder(
            app, TopStoriesDetailsDatabase::class.java, "top_stories_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideGetTopStoriesUseCase(repository: TopStoriesDetailsRepository): GetTopStoriesSectionsUseCase {
        return GetTopStoriesSectionsUseCase(repository)
    }
}