package com.example.anushmp.axolotyl;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class priceAlertJobService extends JobService {

    private static final String TAG = "pricealertanushlogs";
    private boolean jobcancelled = false;
    
    @Override
    public boolean onStartJob(JobParameters params) {

        Log.d(TAG, "onStartJob: price alert set and job started");
        
        dobackgroundwork(params);
        
        return true;
    }

    private void dobackgroundwork(JobParameters params) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "run: ran the job");
                
            }
        }).start();
        
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        
        
        return false;
    }
}
