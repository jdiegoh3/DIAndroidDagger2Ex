package app.fakie.daggerex.di;

import app.fakie.daggerex.di.auth.AuthModule;
import app.fakie.daggerex.di.auth.AuthScope;
import app.fakie.daggerex.di.auth.AuthViewModelsModule;
import app.fakie.daggerex.di.main.MainFragmentBuildersModule;
import app.fakie.daggerex.di.main.MainModule;
import app.fakie.daggerex.di.main.MainScope;
import app.fakie.daggerex.di.main.MainViewModelsModule;
import app.fakie.daggerex.ui.auth.AuthActivity;
import app.fakie.daggerex.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {
    // Let dagger know that AuthActivity will be a potential service consumer.

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class,
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class,
            }
    )
    abstract MainActivity contributeMainActivity();

}
