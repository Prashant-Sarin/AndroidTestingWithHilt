package com.androiddevs.shoppinglisttestingyt.di

import android.content.Context
import androidx.room.Room
import com.androiddevs.shoppinglisttestingyt.common.Constants
import com.androiddevs.shoppinglisttestingyt.common.Constants.BASE_URL
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDao
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItemDatabase
import com.androiddevs.shoppinglisttestingyt.data.remote.PixabayApi
import com.androiddevs.shoppinglisttestingyt.repositories.DefaultShoppingRepoImpl
import com.androiddevs.shoppinglisttestingyt.repositories.ShoppingRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ShoppingItemDatabase::class.java, Constants.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepo(
        dao: ShoppingDao, pixabayApi: PixabayApi
    ) = DefaultShoppingRepoImpl(dao,pixabayApi) as ShoppingRepo

    @Singleton
    @Provides
    fun provideShoppingDao(db: ShoppingItemDatabase) = db.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayApi::class.java)
    }

}