package com.example.lap11799.threadpoolexecutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new StringPrinter().printString();
    }

    public class StringPrinter {

        private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        public void printString() {
            for (int i = 1; i <= 8; i++) {
                threadPoolExecutor.execute(getRunnable(i));
            }
        }

        private Runnable getRunnable(final int i) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String randomString = RandomClass.getRandomString(i);
                    System.out.println("String returned is :" + randomString);
                }
            };
            return runnable;
        }
    }
}
