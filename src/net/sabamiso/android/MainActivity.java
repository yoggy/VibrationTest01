package net.sabamiso.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	VibrationTest01View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		super.onCreate(savedInstanceState);

		view = new VibrationTest01View(this);
		setContentView(view);
		
		view.setup();
		view.invalidate();
	}

	@Override
	protected void onResume() {
		super.onResume();
		view.onResume();
	}

	@Override
	protected void onPause() {
		view.onPause();
		super.onPause();
	}
}
