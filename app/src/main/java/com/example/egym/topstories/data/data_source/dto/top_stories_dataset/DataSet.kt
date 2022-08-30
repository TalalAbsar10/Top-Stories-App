package com.example.egym.topstories.data.data_source.dto.top_stories_dataset

import com.example.egym.topstories.domain.model.TopStoriesItems
import com.example.egym.topstories.util.Constants

class DataSet {

    companion object {

        fun createDataSet(): ArrayList<TopStoriesItems> {
            val list = ArrayList<TopStoriesItems>()
            list.add(TopStoriesItems(Constants.ARTS))
            list.add(TopStoriesItems(Constants.AUTOMOBILES))
            list.add(TopStoriesItems(Constants.BOOKS))
            list.add(TopStoriesItems(Constants.BUSINESS))
            list.add(TopStoriesItems(Constants.FASHION))
            list.add(TopStoriesItems(Constants.FOOD))
            list.add(TopStoriesItems(Constants.HOME))
            list.add(TopStoriesItems(Constants.MOVIES))
            list.add(TopStoriesItems(Constants.OBITUARIES ))
            list.add(TopStoriesItems(Constants.OPINION))
            list.add(TopStoriesItems(Constants.POLITICS))
            list.add(TopStoriesItems(Constants.SPORTS))
            list.add(TopStoriesItems(Constants.TECHNOLOGY))
            list.add(TopStoriesItems(Constants.THEATER))
            list.add(TopStoriesItems(Constants.UPSHOT))
            list.add(TopStoriesItems(Constants.US))
            list.add(TopStoriesItems(Constants.WORLD))
            list.add(TopStoriesItems(Constants.SCIENCE))
            list.add(TopStoriesItems(Constants.TRAVEL))
            list.add(TopStoriesItems(Constants.HEALTH))
            list.add(TopStoriesItems(Constants.MAGAZINE))
            return list
        }
    }
}