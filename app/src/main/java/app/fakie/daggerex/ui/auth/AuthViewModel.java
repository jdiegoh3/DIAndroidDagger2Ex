package app.fakie.daggerex.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.SessionManager;
import app.fakie.daggerex.models.User;
import app.fakie.daggerex.network.auth.AuthApi;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();
    
    private final AuthApi authAPI;
    private final SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authAPI = authApi;
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: ViewModel Working !! C:");
    }

    public void authenticationWithId(int userId){
        sessionManager.authenticatedWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(int userId) {
        return LiveDataReactiveStreams.fromPublisher(authAPI.getUser(userId)
                .onErrorReturn(new Function<Throwable, User>() {
                    @Override
                    public User apply(Throwable throwable) throws Exception {
                        User errorUser = new User();
                        errorUser.setId(-1);
                        return errorUser;
                    }
                })
                .map(new Function<User, AuthResource<User>>() {
                    @Override
                    public AuthResource<User> apply(User user) throws Exception {
                        if(user.getId() == -1){
                            return AuthResource.error("Could not authenticate", null);
                        }
                        return AuthResource.authenticated(user);
                    }
                })
                .subscribeOn(Schedulers.io())

        );

    }

    public LiveData<AuthResource<User>> observeAuthstate(){
        return sessionManager.getAuthUser();
    }

}
