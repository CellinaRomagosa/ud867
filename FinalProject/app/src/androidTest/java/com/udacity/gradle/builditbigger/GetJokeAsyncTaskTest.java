package com.udacity.gradle.builditbigger;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.fail;

/**
 * Created by cars on 1/15/17.
 */
public class GetJokeAsyncTaskTest {
  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testAsyncTask(){
    final CountDownLatch doneSignal = new CountDownLatch(1);

    GetJokeAsyncTask getJokeAsyncTask = new GetJokeAsyncTask(new Callback() {
      @Override
      public void onSuccess(String joke) {
        Assert.assertTrue(joke != null && joke.length() > 0);
        doneSignal.countDown();
      }

      @Override
      public void onError() {
        doneSignal.countDown();
        fail();
      }
    });

    getJokeAsyncTask.execute();
    try {
      doneSignal.await();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}