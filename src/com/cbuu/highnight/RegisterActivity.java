package com.cbuu.highnight;

import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cbuu.highnight.utils.Logger;
import com.cbuu.highnight.utils.MyHttpUtils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	private RequestQueue queue;

	private Button backButton;
	private Button confirmButton;

	private EditText usernameEditText;
	private EditText passwordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		queue = Volley.newRequestQueue(this);

		initActionBar();
		initView();

	}

	private void initActionBar() {
		View customActionbar = getLayoutInflater().inflate(
				R.layout.custom_bar_register, null);

		ActionBar.LayoutParams params = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);

		ActionBar actionBar = getActionBar();
		actionBar.setCustomView(customActionbar, params);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

		backButton = (Button) customActionbar
				.findViewById(R.id.button_back_register);

		backButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(RegisterActivity.this,
						LoginActivity.class));
				RegisterActivity.this.finish();
			}
		});
	}

	private void initView() {
		passwordEditText = (EditText) findViewById(R.id.regist_password);
		usernameEditText = (EditText) findViewById(R.id.regist_username);

		confirmButton = (Button) findViewById(R.id.button_comfirm_register);

		confirmButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String url = MyHttpUtils.getRegisterUrl(usernameEditText
						.getText().toString(), passwordEditText.getText()
						.toString());

				JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
						url, null, new Response.Listener<JSONObject>() {
							@Override
							public void onResponse(JSONObject response) {
								Logger.log("wo" + response.toString());
							}
						}, new Response.ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {
								Logger.log("wocao" + error.getMessage());
							}
						});

				queue.add(jsonObjectRequest);
			}
		});
	}
}
