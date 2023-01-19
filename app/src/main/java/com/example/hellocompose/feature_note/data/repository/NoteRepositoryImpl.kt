package com.example.hellocompose.feature_note.data.repository

import com.example.hellocompose.feature_note.data.data_source.NoteDao
import com.example.hellocompose.feature_note.domain.model.Note
import com.example.hellocompose.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteByID(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNorte(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}