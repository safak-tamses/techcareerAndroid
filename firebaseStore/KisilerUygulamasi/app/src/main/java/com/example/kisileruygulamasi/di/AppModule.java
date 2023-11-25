package com.example.kisileruygulamasi.di;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(CollectionReference collectionKisiler){
        return new KisilerDaoRepository(collectionKisiler);
    }

    @Provides
    @Singleton
    public CollectionReference provideCollectionReference(){
        return FirebaseFirestore.getInstance().collection("Kisiler");
    }
}
