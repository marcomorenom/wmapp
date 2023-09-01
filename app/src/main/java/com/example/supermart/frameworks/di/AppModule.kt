package com.example.supermart.frameworks.di

import android.app.Application
import androidx.room.Room
import com.example.supermart.frameworks.persistance.db.DATABASE_NAME
import com.example.supermart.frameworks.persistance.db.DataBase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofitBuilder(
        gsonConverter: GsonConverterFactory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(gsonConverter)
            .client(OkHttpClient.Builder().build())

    }

    @Provides
    fun provideRetrofit(
        retrofitBuilder: Retrofit.Builder
    ): Retrofit {
        return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun providesDB(application: Application): DataBase {
        return Room.databaseBuilder(
            application.applicationContext,
            DataBase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }
}