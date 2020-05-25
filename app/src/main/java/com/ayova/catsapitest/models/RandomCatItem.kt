package com.ayova.catsapitest.models

data class RandomCatItem(
    val breeds: List<Any>,
    val categories: List<Any>,
    val id: String,
    val url: String
)