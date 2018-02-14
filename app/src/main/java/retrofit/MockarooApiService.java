package retrofit;

import java.util.List;

import datamodels.Party;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tilma on 2018-02-14.
 */

public interface MockarooApiService {

	@GET("/parties.json")
	Call<List<Party>> getUsers(@Query("key") String api_key);

}
