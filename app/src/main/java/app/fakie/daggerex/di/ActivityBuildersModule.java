package app.fakie.daggerex.di;

import app.fakie.daggerex.AuthActivity;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {
    // Let dagger know that AuthActivity will be a potential service consumer.

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String someString(){
        return "Example injection into AuthActivity";
    }
}
