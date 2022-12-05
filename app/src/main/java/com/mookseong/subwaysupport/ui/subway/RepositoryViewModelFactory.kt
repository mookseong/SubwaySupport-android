package com.mookseong.subwaysupport.ui.subway

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.repository.SubwayRepository

class RepositoryViewModelFactory(private val subwayRepository: SubwayRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SubwayRepository::class.java)
            .newInstance(subwayRepository)
    }
}