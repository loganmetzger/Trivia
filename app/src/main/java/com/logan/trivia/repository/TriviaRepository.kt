package com.logan.trivia.repository

import com.logan.trivia.models.TriviaResponse
import com.logan.trivia.remote.RetrofitInstance
import io.reactivex.Single

class TriviaRepository() {
    fun getTrivia(amount: String, category: String, difficulty: String): Single<TriviaResponse> {
        return RetrofitInstance().api.getTrivia("10", "9", "easy")
    }
}