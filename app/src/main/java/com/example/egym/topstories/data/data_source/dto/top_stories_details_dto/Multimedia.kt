package com.example.egym.topstories.data.data_source.dto.top_stories_details_dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Multimedia(
    val caption: String,
    val copyright: String,
    val format: String,
    val height: Int,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
):Parcelable