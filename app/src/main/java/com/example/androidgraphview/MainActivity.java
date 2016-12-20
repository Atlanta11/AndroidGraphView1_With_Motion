package com.example.androidgraphview;

import java.util.Random;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;

public class MainActivity extends Activity {
	
	MyGraphView myGraphView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myGraphView = (MyGraphView)findViewById(R.id.myview);
		
		new MyAsyncTask(myGraphView).execute();

	}
	
	public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

		MyGraphView myTaskView;
		
		MyAsyncTask(MyGraphView v){
			myTaskView = v;
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			Random random = new Random();

			for(int i = 0; i <= 500; i++){
				myTaskView.addItem(i, random.nextInt(500));
				myTaskView.postInvalidate();
				SystemClock.sleep(100);
			}
			
			return null;
		}
		
	}

}
