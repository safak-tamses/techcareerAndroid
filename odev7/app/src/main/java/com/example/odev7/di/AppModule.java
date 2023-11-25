package com.example.odev7.di;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.odev7.data.repo.ToDoDaoRepository;
import com.example.odev7.room.TodoDao;
import com.example.odev7.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public ToDoDaoRepository provideTodoDaoRepository(TodoDao todoDao){

        return new ToDoDaoRepository(todoDao);
    }

    @Provides
    @Singleton
    public TodoDao provideTodoDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class, "todo.sqlite")
                .createFromAsset("todo.sqlite")
                .fallbackToDestructiveMigration() // This line will recreate the database if the version is increased
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        // Database created
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                        // Database opened
                    }
                })
                .build();

        return  vt.getTodoDao();

    }
}
