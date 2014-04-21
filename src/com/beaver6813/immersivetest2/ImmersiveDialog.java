package com.beaver6813.immersivetest2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

public class ImmersiveDialog extends Dialog {

	public ImmersiveDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ImmersiveDialog(Activity context, int theme) {
		super(context, theme);
		copySystemUiVisibility(context);
		
		// TODO Auto-generated constructor stub
		
		
	}

	public ImmersiveDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Copy the visibility of the Activity that has started the dialog {@link mActivity}. If the
	 * activity is in Immersive mode the dialog will be in Immersive mode too and vice versa.
	 */
	private void copySystemUiVisibility(Activity context) {
	    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
	        getWindow().getDecorView().setSystemUiVisibility(
	        		context.getWindow().getDecorView().getSystemUiVisibility());
	    }
	}

}
