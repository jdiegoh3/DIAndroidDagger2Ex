package app.fakie.daggerex.network.main;

import java.util.List;

import app.fakie.daggerex.models.Post;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    // posts?userId=1
    @GET("posts")
    Flowable<List<Post>> getPostFromUser(
            @Query("userId") int userId
    );

}
