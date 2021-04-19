package com.logan.trivia.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.logan.trivia.repository.TriviaRepository

class TriviaViewModelProviderFactory(
    val triviaRepository: TriviaRepository
) : ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return TriviaViewModel(triviaRepository) as T
    }

}