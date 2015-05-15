package com.cbuu.highnight;

import com.cbuu.highnight.*;
import com.cbuu.highnight.common.OnRespondListener;
import com.cbuu.highnight.utils.Logger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends Activity {

	private TextView registerButton = null;
	
	
	private Button loginButton = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        initView();

    }

    private void initView(){
    	registerButton = (TextView)findViewById(R.id.button_to_register);
    	
    	registerButton.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				
				int action = arg1.getAction();
				
				Log.d("test", ""+action);
				
				if (action == MotionEvent.ACTION_DOWN) {
					registerButton.setTextColor(Color.GREEN);
				}
				
				if (action == MotionEvent.ACTION_UP) {
					registerButton.setTextColor(Color.WHITE);
					startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
				}

				
				return true;
			}
		});
    	
    	loginButton = (Button)findViewById(R.id.button_login);
    	loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				MyHttpUtils.postWithHttpClient(new OnRespondListener() {
					
					@Override
					public void onSucceed(String message) {
						Logger.log(message);
					}
					
					@Override
					public void onError(String message) {
						Logger.log(message);
					}
				});
			}
		});
    }
}
