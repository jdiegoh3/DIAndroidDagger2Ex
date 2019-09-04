package app.fakie.daggerex.di;

import android.app.Application;

import javax.inject.Singleton;

import app.fakie.daggerex.BaseApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        // If you want bind a particular object or instance
        // to the component at the time of its construction
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
