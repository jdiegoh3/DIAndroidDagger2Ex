package app.fakie.daggerex.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.models.User;
import app.fakie.daggerex.network.AuthApi;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();
    
    private final AuthApi authAPI;
    private MediatorLiveData<User> authUser = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authAPI = authApi;
        Log.d(TAG, "AuthViewModel: ViewModel Working !! C:");
    }

    public void authenticationWithId(int userId){
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                authAPI.getUser(userId)
                .subscribeOn(Schedulers.io())
        );
        authUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observeUser(){
        return authUser;
    }

}
