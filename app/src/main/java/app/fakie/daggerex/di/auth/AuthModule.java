package app.fakie.daggerex.di.auth;

import app.fakie.daggerex.network.auth.AuthApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthAPI(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
