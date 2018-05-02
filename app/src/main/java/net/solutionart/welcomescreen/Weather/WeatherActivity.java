package net.solutionart.welcomescreen.Weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import net.solutionart.welcomescreen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    TextView textView_WeatherIcon;
    TextView textView_humidity;
    TextView textView_pressure;
    TextView textView_timezone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        try {
            textView_WeatherIcon = (TextView) findViewById(R.id.textViewWeatherIcon);
            textView_humidity = (TextView) findViewById(R.id.textViewhumidity);
            textView_pressure = (TextView) findViewById(R.id.textViewpressure);
            textView_timezone = (TextView) findViewById(R.id.textViewtimezone);

            String url = "https://api.darksky.net/forecast/b1b406d0358035a8a2f3bec9e59e2f97/42.3601,-71.0589";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String timezone = response.getString("timezone");

                        JSONObject jsonObject = response.getJSONObject("currently");

                        String icon = String.valueOf(jsonObject.getString("icon"));
                        String humidity = String.valueOf(jsonObject.getDouble("humidity"));
                        String pressure = String.valueOf(jsonObject.getDouble("pressure"));


                        textView_timezone.setText(timezone);
                        textView_WeatherIcon.setText(icon);
                        textView_humidity.setText(humidity);
                        textView_pressure.setText(pressure);

                        /*
                        JSONObject jsonObject = response.getJSONObject();
                        //JSONArray jsonArray = response.getJSONArray("");
                        //JSONObject object = jsonArray.getJSONObject(0);
                        String icon = String.valueOf(jsonObject.getString("icon"));
                        textView_WeatherIcon.setText(icon);
                        */

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Volley", error.getMessage());
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception ex){
            Log.d("Weather", ex.getMessage());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
