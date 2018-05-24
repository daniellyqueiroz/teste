package br.ufrpe.tiqueru;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class Requests {
    private static Requests mInstance;
    private RequestQueue mQueue;
    public static final String ROOT = "http://35.184.178.70/api/";

    private Requests(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public static Requests getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Requests(context);
        }
        return mInstance;
    }

    public void getObject(String url, Response.Listener<JSONObject> callback, Response.ErrorListener error) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ROOT+url, null, callback, error);
        request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(request);
    }

    public void post(String url, JSONObject data, Response.Listener<JSONObject> callback, Response.ErrorListener error) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ROOT+url, data, callback, error);
        request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(request);
    }

    public void put(String url, JSONObject data, Response.Listener<JSONObject> callback, Response.ErrorListener error) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, ROOT+url, data, callback, error); /*{
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };*/
        request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(request);
    }

    public void delete(String url, JSONObject data, Response.Listener<JSONObject> callback, Response.ErrorListener error) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.DELETE, ROOT+url, data, callback, error);
        request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(request);
    }
}