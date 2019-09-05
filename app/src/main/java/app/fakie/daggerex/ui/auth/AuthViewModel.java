package app.fakie.daggerex.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.network.AuthApi;
import retrofit2.Retrofit;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();
    
    private final AuthApi authAPI;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authAPI = authApi;
        Log.d(TAG, "AuthViewModel: ViewModel Working !! C:");
        
        if(this.authAPI == null){
            Log.d(TAG, "AuthViewModel: Is NULL");
        } else {
            Log.d(TAG, "AuthViewModel: Is NOT NULL");
        }
    }

}
