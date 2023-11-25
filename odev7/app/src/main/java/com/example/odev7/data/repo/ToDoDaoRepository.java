package com.example.odev7.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.odev7.data.entity.ToDo;
import com.example.odev7.room.TodoDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoDaoRepository {
    public MutableLiveData<List<ToDo>> todoListesi = new MutableLiveData<>();
    private TodoDao todoDao;

    public ToDoDaoRepository(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void kaydet(String todo_name){
        ToDo yeniToDo = new ToDo(0,todo_name);
        todoDao.kaydet(yeniToDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void guncelle(int todo_id, String todo_name){
        ToDo guncellenmisTodo = new ToDo(todo_id,todo_name);
        todoDao.guncelle(guncellenmisTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void ara(String aramaKelimesi){
        todoDao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void sil(int todo_id){
        ToDo silinenTodo = new ToDo(todo_id,"");
        todoDao.sil(silinenTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        todoYukle();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void todoYukle(){
        todoDao.todoYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        todoListesi.setValue(toDos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
