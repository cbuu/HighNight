package com.cbuu.highnight.common;

import com.cbuu.highnight.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WeiboFragment extends Fragment implements View.OnClickListener{
	private Weibo weibo = null;
	
	private ImageView image;
	private TextView content;
	private TextView publishTime;
	private TextView number;
	
	
	private ImageButton likeButton;
	private TextView likeNum;
	
	private ImageButton dislikeButton;
	private TextView dislikeNum;
	
	private Button contactButton;
	
	public WeiboFragment(Weibo weibo){
		this.weibo = weibo;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.single_item, null);
	
		image = (ImageView)view.findViewById(R.id.image);
		
		publishTime = (TextView)view.findViewById(R.id.publish_time);
		number = (TextView)view.findViewById(R.id.number);
		content = (TextView)view.findViewById(R.id.content);
		likeNum = (TextView)view.findViewById(R.id.num_like);
		dislikeNum = (TextView)view.findViewById(R.id.num_dislike);
		
		likeButton = (ImageButton)view.findViewById(R.id.button_like);
		likeButton = (ImageButton)view.findViewById(R.id.button_like);
		
		contactButton = (Button)view.findViewById(R.id.button_contact);
		
		bindData();
		
		return view;
	}
	
	public Weibo getWeibo(){
		return weibo;
	}
	
	public void bindData(){
		content.setText(weibo.getText());
		dislikeNum.setText(""+weibo.getShitNum());
		likeNum.setText(""+weibo.getStarNum());
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) 
		{
		case R.id.button_contact:
			
			break;
		case R.id.button_dislike:
			
			break;
			
		case R.id.button_like:
			
			break;
		default:
			break;
		}
	}
}
