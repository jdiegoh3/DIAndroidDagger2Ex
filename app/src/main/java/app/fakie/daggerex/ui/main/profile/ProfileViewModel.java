package app.fakie.daggerex.ui.main.profile;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import app.fakie.daggerex.SessionManager;
import app.fakie.daggerex.models.User;
import app.fakie.daggerex.ui.auth.AuthResource;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: ViewModel for ProfileFragment is ready.. c:");
        Log.d(TAG, "ProfileViewModel: " + sessionManager.getAuthUser().getValue().data.getEmail());
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }

}
