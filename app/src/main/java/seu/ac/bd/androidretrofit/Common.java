package seu.ac.bd.androidretrofit;

import seu.ac.bd.androidretrofit.Remote.IpService;
import seu.ac.bd.androidretrofit.Remote.RetrofitClient;

/**
 * Created by rakib on 27/08/17.
 */

public class Common {
    private static final String BASE_URL="http://ip.jsontest.com/";

    static IpService getIpService(){
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
