package com.udacity.gradle.builditbigger;

/**
 * Created by cars on 1/15/17.
 */

public interface Callback {
  void onSuccess(String joke);
  void onError();

}
