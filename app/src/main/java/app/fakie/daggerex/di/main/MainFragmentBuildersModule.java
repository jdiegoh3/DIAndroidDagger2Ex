package app.fakie.daggerex.di.main;

import app.fakie.daggerex.ui.main.posts.PostFragment;
import app.fakie.daggerex.ui.main.profile.ProfileFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract ProfileFragment constributesProfileFragment();

    @ContributesAndroidInjector()
    abstract PostFragment contributePostFragment();

}
