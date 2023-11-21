package com.example.kisileruygulamasi.data.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.kisileruygulamasi.data.entity.Kisiler;

@Database(entities = {Kisiler.class}, version = 1)

public abstract class Veritabanı extends RoomDatabase {
    public abstract KisilerDao getKisilerDao();
}
