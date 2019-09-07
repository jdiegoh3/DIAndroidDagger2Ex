package app.fakie.daggerex;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import app.fakie.daggerex.models.User;
import app.fakie.daggerex.ui.auth.AuthResource;

@Singleton
public class SessionManager {

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {

    }

    public void authenticatedWithId(final LiveData<AuthResource<User>> source){
        if(cachedUser != null){
            cachedUser.setValue(AuthResource.loading((User)null));
            cachedUser.addSource(source, new Observer<AuthResource<User>>() {
                @Override
                public void onChanged(AuthResource<User> userAuthResource) {
                    cachedUser.setValue(userAuthResource);
                    cachedUser.removeSource(source);
                }
            });
        }
    }

    public void logOut(){
        cachedUser.setValue(AuthResource.<User>logout());
    }

    public LiveData<AuthResource<User>> getAuthUser(){
        return cachedUser;
    }

}
