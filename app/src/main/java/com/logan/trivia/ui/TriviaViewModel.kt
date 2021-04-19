package com.logan.trivia.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.logan.trivia.models.ResultDTO
import com.logan.trivia.models.TriviaResponse
import com.logan.trivia.repository.TriviaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TriviaViewModel() : ViewModel() {
    private val disposable = CompositeDisposable()
    private val triviaRepository: TriviaRepository by lazy {
        TriviaRepository()
    }

    val currentQuestion: Int = 0
    val correctAnswers: Int = 0

    val _triviaQuestionList: MutableLiveData<List<ResultDTO>> = MutableLiveData()
    val triviaQuestionList get() = _triviaQuestionList

    init {
        getTrivia()
    }

    companion object {
        private val TAG = TriviaViewModel::class.java.name
    }

    private fun getTrivia() {
        disposable.add(
            triviaRepository.getTrivia("10", "9", "easy").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTriviaSuccess, this::onGetTriviaError)
        )
    }

    private fun onGetTriviaSuccess(triviaQuestions: TriviaResponse) {
        _triviaQuestionList.value = triviaQuestions.results
    }

    private fun onGetTriviaError(e: Throwable) {
        e.message.let {
            Log.d(TAG, it.toString())
        }
    }

}