package com.themakcym.gtd.domain.models

import java.util.UUID
import java.time.LocalDateTime


data class Task (
    var taskTitle: String,
    var groupId: UUID,
    val taskId: UUID = UNDEFINED_ID,
    var taskDesc: String = "",
    var isCompleted: Boolean = false,
    var taskUpdated: LocalDateTime = LocalDateTime.now(),
    val tagsIds: List<UUID> = listOf(),
)  {
    companion object {
        val UNDEFINED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
    }

    fun isUndefined(): Boolean {
        return taskId == UNDEFINED_ID
    }

    fun describe(desc: String): Task {
        taskDesc = desc
        return this
    }
}