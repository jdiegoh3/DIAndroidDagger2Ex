package app.fakie.daggerex.ui.auth;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {

    private static final String TAG = AuthViewModel.class.getSimpleName();

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel: ViewModel Working !! C:");
    }

}
