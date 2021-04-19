package com.logan.trivia.models

import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("category")val category: String,
    @SerializedName("correct_answer")val correct_answer: String,
    @SerializedName("difficulty")val difficulty: String,
    @SerializedName("incorrect_answers")val incorrect_answers: List<String>,
    @SerializedName("question")val question: String,
    @SerializedName("type")val type: String
)