package app.fakie.daggerex.di.main;

import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.di.ViewModelKey;
import app.fakie.daggerex.ui.main.posts.PostsViewModel;
import app.fakie.daggerex.ui.main.profile.ProfileViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostViewModel(PostsViewModel viewModel);

}
