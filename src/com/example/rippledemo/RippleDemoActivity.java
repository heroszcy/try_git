package com.example.rippledemo;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class RippleDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("zcy", "Oncreate");
		setContentView(R.layout.main_activity);
		View btn = findViewById(R.id.image_btn);
		ImageView image = (ImageView) findViewById(R.id.image);
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "tosat", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				intent.setClassName("com.android.dialer", "com.android.contacts.activities.ContactSelectionActivity");
				startActivity(intent);
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
		});
//		try {
//			 ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
//			 if(info.metaData != null){
//				 String dltype = info.metaData.getString("dltype");
//				 Toast.makeText(getApplicationContext(), dltype + "", Toast.LENGTH_SHORT).show();
//			 }
//		} catch (NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Intent intent = getIntent();
//		Set<String> categories = intent.getCategories();
//		for (String string : categories) {
//			Log.d("zcy", string);
//		}
//		String action = intent.getAction();
//		Log.d("zcy", action);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		super.onKeyDown(keyCode, event);
		return true;
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Log.d("zcy", "onBackPressed");
		super.onBackPressed();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("zcy", "onStop" + isAppOnForeground());
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("zcy", "onDestroy");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ComponentName component = getIntent().getComponent();
		Log.d("zcy", component.getClassName());
		ViewPager viewPager;
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("zcy", "onStart");
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d("zcy", "onSaveInstanceState");
	}
	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		Log.d("zcy", "onAttachedToWindow");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("zcy", "onPause");
	}
	/** 
     * Whether the program running in the foreground
     *  
     * @return 
     */  
    public boolean isAppOnForeground() {  
            // Returns a list of application processes that are running on the  
            // device  
            ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);  
            String packageName = getApplicationContext().getPackageName();  

            List<RunningAppProcessInfo> appProcesses = activityManager  
                            .getRunningAppProcesses();  
            if (appProcesses == null)  
                    return false;  

            for (RunningAppProcessInfo appProcess : appProcesses) {  
                    // The name of the process that this object is associated with.  
                    if (appProcess.processName.equals(packageName)  
                                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                            return true;
                    }
            }
            return false;  
    }
    
}
