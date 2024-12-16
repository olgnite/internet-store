package com.troevpopke.common.models

data class Reviews(
    val rating: Number,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String,
)
