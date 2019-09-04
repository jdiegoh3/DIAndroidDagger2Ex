package app.fakie.daggerex.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    // Not abstract, i don't use contributesAndroidInjector.

    // Will exists into the entire lifetime of the application.
    @Provides
    static String someString(){
        return "Example injection into AuthActivity";
    }

    @Provides
    static boolean getApp(Application application){
        return application == null;
    }

    @Provides
    static int someInt(String string){
        if(string.equals(("Example injection into AuthActivity"))){
            return 1;
        }
        return 0;
    }

}
