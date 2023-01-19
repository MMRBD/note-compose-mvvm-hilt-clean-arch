package com.example.hellocompose.feature_note.domain.use_case

data class NoteUseCase(
    val getNotes: GetNoteUseCase,
    val deleteNote: DeleteNoteUseCase
)
