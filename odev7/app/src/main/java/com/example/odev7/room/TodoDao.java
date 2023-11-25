package com.example.odev7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.odev7.data.entity.ToDo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo ")
    Single<List<ToDo>> todoYukle();

    @Insert
    Completable kaydet(ToDo todo);

    @Update
    Completable guncelle(ToDo todo);

    @Delete
    Completable sil(ToDo toDo);

    @Query("SELECT * FROM todo WHERE todo_name LIKE '%' || :aramaKelimesi || '%'")
    Single<List<ToDo>> ara(String aramaKelimesi);
}
