package com.indra

import com.google.gson.GsonBuilder
import com.indra.data.datasource.local.MovieLocalDataSource
import com.indra.data.datasource.local.MovieLocalDataSourceImpl
import com.indra.data.datasource.local.database.AppDataBase
import com.indra.data.datasource.remote.MovieRemoteDataSource
import com.indra.data.datasource.remote.MovieRemoteDataSourceImpl
import com.indra.data.datasource.remote.service.MovieService
import com.indra.data.repository.LoginRepositoryImpl
import com.indra.data.repository.MovieRepositoryImpl
import com.indra.domain.repository.LoginRepository
import com.indra.domain.repository.MovieRepository
import com.indra.domain.usecases.LoginUseCase
import com.indra.domain.usecases.MovieUseCase
import com.indra.presentation.features.splash.SplashViewModel
import com.indra.presentation.utils.Connectivity
import com.tmdb.tv.data.service.MovieInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appComponent = listOf(
    createService("https://api.themoviedb.org/3/"),
    createViewModels(),
    createUseCases(),
    createDataBase(),
    createRepositories(),
    createDataSources(),
    createUtils()
)

fun createViewModels() = module{
    viewModel { SplashViewModel(get()) }
}

fun createRepositories() = module{
    factory { MovieRepositoryImpl(get(), get()) as MovieRepository }
    factory { LoginRepositoryImpl() as LoginRepository }
}

fun createUseCases() = module{
    factory { MovieUseCase(get(), get()) }
    factory { LoginUseCase(get()) }
}

fun createDataSources() = module{
    factory { MovieRemoteDataSourceImpl(get()) as MovieRemoteDataSource }
    factory { MovieLocalDataSourceImpl(get()) as MovieLocalDataSource }
}

fun createDataBase() = module{
    val database = "DATABASE"
    single(named(database)) { AppDataBase.buildDatabase(androidContext()) }
    factory { (get(named(database)) as AppDataBase).movieDao() }
}

fun createUtils() = module{
    factory { Connectivity(get()) }
}

fun createService(baseUrl: String) = module {

    single {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.apply { logginInterceptor.level = HttpLoggingInterceptor.Level.BODY }

        val movieInterceptor = MovieInterceptor()

        OkHttpClient.Builder()
            .addInterceptor(logginInterceptor)
            .addInterceptor(movieInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    factory { get<Retrofit>().create(MovieService::class.java) }

}