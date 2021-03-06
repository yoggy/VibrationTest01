package net.sabamiso.android.vibrationtest01;

import net.sabamiso.android.p5.PseudoP5View;
import android.content.Context;
import android.os.Vibrator;

public class VibrationTest01View extends PseudoP5View {

	boolean old_mousePressed = false;
	float old_mouseX;
	float old_mouseY;
	float diffX;
	float diffY;
	int line_weight = 3;
	int vibrate_time = 20;

	boolean debug = false;

	Vibrator vibrator;

	public VibrationTest01View(Context context) {
		super(context);
		vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Override
	protected void setup() {
		size(360, 640);
		frameRate(60);
		background(0, 0, 0);
	}

	public void onResume() {
		super.onResume();
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	protected void draw() {
		process();

		background(0, 0, 0);

		noFill();
		stroke(255, 255, 255);
		strokeWeight(line_weight);
		line(width / 2, 0, width / 2, height);

		if (mousePressed && debug) {
			noFill();
			stroke(255, 255, 255);
			strokeWeight(3);
			line(old_mouseX, old_mouseY, mouseX, mouseY);

			if (abs(diffX) + abs(diffY) > 0) {
				float px = mouseX + diffX * 10;
				float py = mouseY + diffY * 10;

				stroke(0, 255, 0);
				strokeWeight(3);

				line(mouseX, mouseY, px, py);
			}

			fill(255, 255, 0);
			noStroke();
			ellipse(mouseX, mouseY, 10, 10);

			fill(255, 0, 0);
			noStroke();
			ellipse(old_mouseX, old_mouseY, 10, 10);
		}

		old_mousePressed = mousePressed;
		old_mouseX = mouseX;
		old_mouseY = mouseY;
	}

	void process() {
		if (old_mousePressed == false && mousePressed == true) {
			old_mouseX = mouseX;
			old_mouseY = mouseY;
		} else if (old_mousePressed == true && mousePressed == false) {
		}

		diffX = mouseX - old_mouseX;
		diffY = mouseY - old_mouseY;

		float centerX = width / 2;

		if (mousePressed) {
			if ((old_mouseX <= centerX && centerX <= mouseX)
					|| (mouseX <= centerX && centerX <= old_mouseX)) {
				vibrator.vibrate(vibrate_time);
			}

		}
	}

	public void setLineWeight(int val) {
		line_weight = val;
	}

	public void setVibrateTime(int val) {
		vibrate_time = val;
	}

	public void toggleDebugDisplay() {
		debug = !debug;
	}

}
