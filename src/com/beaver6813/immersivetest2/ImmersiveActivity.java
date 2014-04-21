package com.beaver6813.immersivetest2;
import com.beaver6813.ImmersiveTest2.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ImmersiveActivity extends Activity {

	public ImmersiveActivity() {
		// TODO Auto-generated constructor stub
	}
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_fullscreen);
        
        final Activity context = this;
        
        Button button = (Button) findViewById(R.id.dummy_button);
        
		// add button listener
		button.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
 
			// custom dialog
			final Dialog dialog = new ImmersiveDialog(context);
			dialog.setContentView(R.layout.test_dialog);
			dialog.setTitle("Title...");
 
			// set the custom dialog components - text, image and button
			TextView text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Android custom dialog example!");
			ImageView image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.ic_launcher);
 
			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
 
			dialog.show();
		  }
		});
        
    }
	
	@SuppressLint("NewApi")
	private void disableImmersiveMode() {
	    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
	        getWindow().getDecorView().setSystemUiVisibility(
	                View.SYSTEM_UI_FLAG_FULLSCREEN);

	    }
	}

	@SuppressLint("NewApi")
	private void enableImmersiveMode() {
	    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
	        getWindow().getDecorView().setSystemUiVisibility(
	                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
	                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
	                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
	                        View.SYSTEM_UI_FLAG_FULLSCREEN |
	                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
	                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	        
	    }
	}


	/**
	 * Set the Immersive mode or not according to its state: enabled or not.
	 */
	protected void updateSystemUiVisibility() {
	    // Retrieve if the Immersive mode is enabled or not.
		enableImmersiveMode();
	}

	@Override
	public void onResume() {
	    super.onResume();
	    updateSystemUiVisibility();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
	    super.onWindowFocusChanged(hasFocus);
	    updateSystemUiVisibility();
	}


}
