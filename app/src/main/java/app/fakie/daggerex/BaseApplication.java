package app.fakie.daggerex;

import app.fakie.daggerex.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // Return our AppComponent.
        return DaggerAppComponent.builder().application(this).build();
    }
}
