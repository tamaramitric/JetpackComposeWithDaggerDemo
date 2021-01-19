package com.example.jetpackcomposelearning.dependencyinjection

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkingModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class]
)

interface AppComponent : AndroidInjector<AppController> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<AppController?>
}