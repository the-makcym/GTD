package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel() {

    private val repo = Dep.repo

    private val createGroupUC = CreateGroupUC(repo)
    private val getGroupsUC = GetGroupsUC(repo)
    private val dropAllUC = DropAllUC(repo)

    private var initialized = false
    val groups = MutableLiveData<List<Group>>()

    fun initialize() {
        if (!initialized) {
            viewModelScope.launch {
                dropAllUC.execute()
                val bucket = Group("Bucket", UUID.randomUUID())
                val delayed = Group("Delayed", UUID.randomUUID())
                createGroupUC.execute(bucket)
                createGroupUC.execute(delayed)
                groups.postValue(getGroupsUC.execute())
                initialized = true
            }
        }
    }

    fun getGroups() {
        viewModelScope.launch {
            groups.postValue(getGroupsUC.execute())
        }
    }
}