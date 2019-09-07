package app.fakie.daggerex.di;

import app.fakie.daggerex.di.auth.AuthModule;
import app.fakie.daggerex.di.auth.AuthViewModelsModule;
import app.fakie.daggerex.di.main.MainFragmentBuildersModule;
import app.fakie.daggerex.ui.auth.AuthActivity;
import app.fakie.daggerex.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {
    // Let dagger know that AuthActivity will be a potential service consumer.

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class,
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
            }
    )
    abstract MainActivity contributeMainActivity();

}
