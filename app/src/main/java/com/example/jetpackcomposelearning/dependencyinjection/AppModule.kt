package com.example.jetpackcomposelearning.dependencyinjection

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: AppController): Application {
        return app
    }
}