package retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tilma on 2018-02-12.
 */

public class ServiceGenerator {

	private static String BASE_URL = "https://my.api.mockaroo.com";

	private static Retrofit.Builder builder =
			new Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create());

	private static Retrofit retrofit = builder.build();

	private static HttpLoggingInterceptor logging =
			new HttpLoggingInterceptor()
					.setLevel(HttpLoggingInterceptor.Level.BODY);

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	@SuppressWarnings("unused")
	public static <S> S createService (Class<S> serviceClass){

		if(!httpClient.interceptors().contains(logging)){

			httpClient.addInterceptor(logging);
			builder.client(httpClient.build());
			retrofit = builder.build();

		}

		return retrofit.create(serviceClass);

	}
}
