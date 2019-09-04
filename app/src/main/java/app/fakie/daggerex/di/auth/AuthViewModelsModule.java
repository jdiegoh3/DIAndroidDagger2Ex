package app.fakie.daggerex.di.auth;

import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.di.ViewModelKey;
import app.fakie.daggerex.ui.auth.AuthViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);


}
