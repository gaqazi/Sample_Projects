package ga.com.samplephpapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView respponseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        respponseTv = (TextView) findViewById(R.id.respponse);
        post();
    }

    private void get(){
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get("http://brotherstech.net/ssuet/api.php",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                respponseTv.setText(response.toString());
            }
        });
    }

    private void post(){
        Contact contact = new Contact(1,"Miss Gulshan");
        RequestParams params = new RequestParams();
        params.put("data",(new Gson()).toJson(contact));
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.post("http://brotherstech.net/ssuet/api.php", params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                respponseTv.setText(response.toString());
            }
        });
    }


}
