package crp.com.volleydirect;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;


/*Created by CRP*/

public class VolleyAPI {

    public void postMethod(final Activity activity, final ProgressBar progressBar, final String url,
                           final Map<String, String> params, final VolleyCallback callback) {
        if (CheckConnection.isConnectingToInternet(activity)) {
            progressBar.setVisibility(View.VISIBLE);
            StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                    new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e(activity.getClass().getSimpleName(), response);
                            progressBar.setVisibility(View.GONE);
                            callback.onSuccess(response);
                        }
                    },
                    new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            String message = "";
                            if (volleyError instanceof NetworkError) {
                                message = "Cannot connect to Internet...Please check your connection!";

                            } else if (volleyError instanceof ServerError) {
                                message = "The server could not be found. Please try again after some time!!";
                            } else if (volleyError instanceof AuthFailureError) {
                                message = "Cannot connect to Internet...Please check your connection!";
                            } else if (volleyError instanceof ParseError) {
                                message = "Parsing error! Please try again after some time!!";
                            } else if (volleyError instanceof TimeoutError) {
                                message = "Connection TimeOut! Please check your internet connection.";
                            }
                            Log.e(activity.getClass().getSimpleName(), message);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity, R.string.something, Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    return params;
                }
            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } else {

            Log.e(activity.getClass().getSimpleName(), "Internet Error");
            Toast.makeText(activity, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    public void getMethod(final Activity activity, final ProgressBar progressBar, final String url,
                          final VolleyCallback callback) {
        if (CheckConnection.isConnectingToInternet(activity)) {
            progressBar.setVisibility(View.VISIBLE);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e(activity.getClass().getSimpleName(), response);
                            progressBar.setVisibility(View.GONE);
                            callback.onSuccess(response);
                        }
                    },
                    new com.android.volley.Response.ErrorListener() {
                        @Override

                        public void onErrorResponse(VolleyError volleyError) {
                            String message = "";
                            if (volleyError instanceof NetworkError) {
                                message = "Cannot connect to Internet...Please check your connection!";

                            } else if (volleyError instanceof ServerError) {
                                message = "The server could not be found. Please try again after some time!!";
                            } else if (volleyError instanceof AuthFailureError) {
                                message = "Cannot connect to Internet...Please check your connection!";
                            } else if (volleyError instanceof ParseError) {
                                message = "Parsing error! Please try again after some time!!";
                            } else if (volleyError instanceof TimeoutError) {
                                message = "Connection TimeOut! Please check your internet connection.";
                            }
                            Log.e(activity.getClass().getSimpleName(), message);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity, R.string.something, Toast.LENGTH_SHORT).show();
                        }



                      /*  public void onErrorResponse(VolleyError error) {
                            Log.e(activity.getClass().getSimpleName(),error.getMessage());
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity, R.string.something, Toast.LENGTH_SHORT).show();
                        }*/
                    }) {
            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } else {

            Log.e(activity.getClass().getSimpleName(), "Internet Error");
            Toast.makeText(activity, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

    public void postMethodNoProgressBar(final Activity activity, final String url,
                                        final Map<String, String> params, final VolleyCallback callback) {
        if (CheckConnection.isConnectingToInternet(activity)) {

            StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url,
                    new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e(activity.getClass().getSimpleName(), response);

                            callback.onSuccess(response);
                        }
                    },
                    new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            String message = "";
                            if (volleyError instanceof NetworkError) {
                                message = "Cannot connect to Internet...Please check your connection!";

                            } else if (volleyError instanceof ServerError) {
                                message = "The server could not be found. Please try again after some time!!";
                            } else if (volleyError instanceof AuthFailureError) {
                                message = "Cannot connect to Internet...Please check your connection!";
                            } else if (volleyError instanceof ParseError) {
                                message = "Parsing error! Please try again after some time!!";
                            } else if (volleyError instanceof TimeoutError) {
                                message = "Connection TimeOut! Please check your internet connection.";
                            }
                            Log.e(activity.getClass().getSimpleName(), message);

                            Toast.makeText(activity, R.string.something, Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    return params;
                }
            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } else {

            Log.e(activity.getClass().getSimpleName(), "Internet Error");
            Toast.makeText(activity, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }
    }

}
