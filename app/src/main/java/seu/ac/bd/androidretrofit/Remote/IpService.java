package seu.ac.bd.androidretrofit.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import seu.ac.bd.androidretrofit.Model.Ip;

/**
 * Created by rakib on 27/08/17.
 */

public interface IpService {
    @GET("/")
    Call<Ip> getIp();
}
