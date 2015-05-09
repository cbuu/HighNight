package com.example.highnight;

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
import android.widget.TextView;


public class LoginActivity extends Activity {

	private TextView registerButton = null;
	
	
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
    }
}
