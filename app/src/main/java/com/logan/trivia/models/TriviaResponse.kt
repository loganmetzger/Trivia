package com.logan.trivia.models

import com.google.gson.annotations.SerializedName

data class TriviaResponse(
    @SerializedName("results")val results: List<ResultDTO>
)