package com.example.egym.topstories.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [TopStoriesDetailsEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TopStoriesDetailsDatabase : RoomDatabase() {

    abstract val dao: TopStoriesDetailsDao
}