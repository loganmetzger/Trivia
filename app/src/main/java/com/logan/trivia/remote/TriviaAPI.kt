package com.logan.trivia.remote

import com.logan.trivia.models.TriviaResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaAPI {
    @GET("api.php")
    fun getTrivia(
        @Query("amount")
        amount: String = "10",

        @Query("category")
        category: String = "9",

        @Query("difficulty")
        difficulty: String = "easy"
    ): Single<TriviaResponse>
}