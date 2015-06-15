package com.cbuu.highnight.fragment;

import com.cbuu.highnight.MainActivity;
import com.cbuu.highnight.R;
import com.cbuu.highnight.SingleChatActivity;
import com.cbuu.highnight.base.MyFragment;
import com.cbuu.highnight.dialog.PublishDialog;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;

public class SingleFragment extends MyFragment {

	private ImageButton publishButton;
	private ImageButton contactButton;

	public SingleFragment(String tabName) {
		super(tabName);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_single, null);

		contactButton = (ImageButton) view.findViewById(R.id.button_contact);
		contactButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getActivity(),
						SingleChatActivity.class));
			}
		});

		publishButton = (ImageButton) view.findViewById(R.id.button_publish);
		publishButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				PublishDialog dialog = new PublishDialog(getActivity());
				Window window = dialog.getWindow();
				window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
				window.setWindowAnimations(R.style.publish_dialog_anim); // 添加动画
				dialog.show();
			}
		});

		return view;
	}
}
