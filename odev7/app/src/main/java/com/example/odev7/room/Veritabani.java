package com.example.odev7.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.odev7.data.entity.ToDo;

@Database(entities = {ToDo.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract TodoDao getTodoDao();
}
