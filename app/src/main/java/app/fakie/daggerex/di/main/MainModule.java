package app.fakie.daggerex.di.main;

import app.fakie.daggerex.network.main.MainApi;
import app.fakie.daggerex.ui.main.posts.PostsRecyclerAdapter;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

    @MainScope
    @Provides
    static PostsRecyclerAdapter provideAdapter(){
        return new PostsRecyclerAdapter();
    }

}
