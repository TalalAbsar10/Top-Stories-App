package com.example.egym.topstories.data.data_source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TopStoriesDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopStoriesDetails(stories: TopStoriesDetailsEntity)

    @Query("SELECT * FROM topstoriesdb WHERE section LIKE '%' || :section || '%'")
    suspend fun getTopStoriesDetails(section: String): TopStoriesDetailsEntity

}