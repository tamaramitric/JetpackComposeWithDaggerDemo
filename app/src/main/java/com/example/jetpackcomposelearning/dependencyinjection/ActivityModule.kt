package com.example.jetpackcomposelearning.dependencyinjection

import com.example.jetpackcomposelearning.listscreen.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): ListActivity
}