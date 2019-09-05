package app.fakie.daggerex.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.models.User;
import app.fakie.daggerex.network.AuthApi;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();
    
    private final AuthApi authAPI;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authAPI = authApi;
        Log.d(TAG, "AuthViewModel: ViewModel Working !! C:");
        
        this.authAPI.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.getEmail());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: Error Auth api" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
