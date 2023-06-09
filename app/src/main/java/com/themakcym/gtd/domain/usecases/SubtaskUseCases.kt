package com.themakcym.gtd.domain.usecases

import java.util.UUID
import com.themakcym.gtd.domain.models.Subtask
import com.themakcym.gtd.domain.Repository


class CreateSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        subtask.subtaskDetails = subtask.subtaskDetails.trim()
        repo.createSubtask(subtask)
    }
}

class DeleteSubtasksByTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID) {
        repo.deleteSubtasksByTask(taskId)
    }
}

class SelectSubtasksByTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID): List<Subtask> {
        return repo.selectSubtasksByTask(taskId)
    }
}
