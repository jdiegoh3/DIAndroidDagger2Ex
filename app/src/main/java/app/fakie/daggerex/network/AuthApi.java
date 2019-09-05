package app.fakie.daggerex.network;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface AuthApi {

    @GET
    Flowable<ResponseBody> getApiData();
}
