package com.example.coroutine.callMultiAPI.model.one

data class ChartModel(
    val competition: Competition,
    val filters: Filters,
    val season: Season,
    val standings: List<Standing>
)