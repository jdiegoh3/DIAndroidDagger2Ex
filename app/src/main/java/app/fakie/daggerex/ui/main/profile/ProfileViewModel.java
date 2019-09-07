package app.fakie.daggerex.ui.main.profile;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    @Inject
    public ProfileViewModel() {
        Log.d(TAG, "ProfileViewModel: ViewModel for ProfileFragment is ready.. c:");
    }
}