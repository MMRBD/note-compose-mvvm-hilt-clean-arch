package com.example.hellocompose.di

import android.app.Application
import androidx.room.Room
import com.example.hellocompose.feature_note.data.data_source.NoteDatabase
import com.example.hellocompose.feature_note.data.data_source.NoteDatabase.DatabaseName.DB_NAME
import com.example.hellocompose.feature_note.data.repository.NoteRepositoryImpl
import com.example.hellocompose.feature_note.domain.repository.NoteRepository
import com.example.hellocompose.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.hellocompose.feature_note.domain.use_case.GetNoteUseCase
import com.example.hellocompose.feature_note.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNoteUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository)
        )
    }
}