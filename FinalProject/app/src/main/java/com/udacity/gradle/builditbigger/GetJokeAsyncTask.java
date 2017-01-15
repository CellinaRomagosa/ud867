package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.cars.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

class GetJokeAsyncTask extends AsyncTask<Context , Void, String> {
  private static MyApi myApiService = null;
  private Context context;
  private Callback callback;

  public GetJokeAsyncTask(Callback callback){
    this.callback = callback;
  }

  @Override
  protected String doInBackground(Context ... context) {
    if(myApiService == null) {  // Only do this once
      MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          // options for running against local devappserver
          // - 10.0.2.2 is localhost's IP address in Android emulator
          // - turn off compression when running against local devappserver
          .setRootUrl("http://10.0.2.2:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });
      // end options for devappserver

      myApiService = builder.build();

    }


    try {
      String joke =myApiService.getJoke().execute().getData();
      callback.onSuccess( joke );
      return joke;
    } catch (IOException e) {
      return e.getMessage();
    }
  }



  @Override
  protected void onPostExecute(String result) {
  }
}