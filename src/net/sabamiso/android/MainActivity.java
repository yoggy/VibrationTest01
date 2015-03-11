package net.sabamiso.android;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	VibrationTest01View view;

	public static final int MENU_TOGGLE_DEBUG_DISPLAY = 0;
	public static final int MENU_LINE_WEIGHT_04 = 1;
	public static final int MENU_LINE_WEIGHT_16 = 2;
	public static final int MENU_LINE_WEIGHT_64 = 3;
	public static final int MENU_LINE_WEIGHT_128 = 4;
	
	public static final int MENU_VIBRATE_TIME_010 = 11;
	public static final int MENU_VIBRATE_TIME_020 = 12;
	public static final int MENU_VIBRATE_TIME_040 = 13;
	public static final int MENU_VIBRATE_TIME_080 = 14;
	public static final int MENU_VIBRATE_TIME_160 = 15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		super.onCreate(savedInstanceState);

	    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH){
	        requestWindowFeature(Window.FEATURE_ACTION_BAR);
	    }
	    else{
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	    }
		
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
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu){
	    menu.add(Menu.NONE, MENU_TOGGLE_DEBUG_DISPLAY, Menu.NONE, "toggle debug display");
	    menu.add(Menu.NONE, MENU_LINE_WEIGHT_04, Menu.NONE, "line_weight=4");
	    menu.add(Menu.NONE, MENU_LINE_WEIGHT_16, Menu.NONE, "line_weight=16");
	    menu.add(Menu.NONE, MENU_LINE_WEIGHT_64, Menu.NONE, "line_weight=64");
	    menu.add(Menu.NONE, MENU_LINE_WEIGHT_128, Menu.NONE, "line_weight=128");
	    menu.add(Menu.NONE, MENU_VIBRATE_TIME_010, Menu.NONE, "vibrate_time=10ms");
	    menu.add(Menu.NONE, MENU_VIBRATE_TIME_020, Menu.NONE, "vibrate_time=20ms");
	    menu.add(Menu.NONE, MENU_VIBRATE_TIME_040, Menu.NONE, "vibrate_time=40ms");
	    menu.add(Menu.NONE, MENU_VIBRATE_TIME_080, Menu.NONE, "vibrate_time=80ms");
	    menu.add(Menu.NONE, MENU_VIBRATE_TIME_160, Menu.NONE, "vibrate_time=160ms");
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case MENU_TOGGLE_DEBUG_DISPLAY:
	    	view.toggleDebugDisplay();
	        return true;	 
	    case MENU_LINE_WEIGHT_04:
	    	view.setLineWeight(4);
	        return true;	 
	    case MENU_LINE_WEIGHT_16:
	    	view.setLineWeight(16);
	        return true;	 
	    case MENU_LINE_WEIGHT_64:
	    	view.setLineWeight(64);
	        return true;	 
	    case MENU_VIBRATE_TIME_010:
	    	view.setVibrateTime(10);
	        return true;	 
	    case MENU_VIBRATE_TIME_020:
	    	view.setVibrateTime(20);
	        return true;	 
	    case MENU_VIBRATE_TIME_040:
	    	view.setVibrateTime(40);
	        return true;	 
	    case MENU_VIBRATE_TIME_080:
	    	view.setVibrateTime(80);
	        return true;	 
	    case MENU_VIBRATE_TIME_160:
	    	view.setVibrateTime(160);
	        return true;	 
	    }
	    return false;
	}
}
