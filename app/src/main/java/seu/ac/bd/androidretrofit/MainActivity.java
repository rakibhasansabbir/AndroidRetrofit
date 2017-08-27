package seu.ac.bd.androidretrofit;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seu.ac.bd.androidretrofit.Model.Ip;
import seu.ac.bd.androidretrofit.Remote.IpService;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView txtIp;
    Button btnGetIp;
    SpotsDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();

        btnGetIp = (Button)findViewById(R.id.btnGetIP);
        txtIp = (TextView)findViewById(R.id.textIP);
        dialog = new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                getIpAddress();
            }
        });

    }

    private void getIpAddress() {

        mService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {

                dialog.dismiss();
                txtIp.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {

                Log.e("ERROR",t.getMessage());
                dialog.dismiss();

            }
        });
    }
}
