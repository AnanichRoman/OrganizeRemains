package com.appsrox.remindme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

public class CheckedImageView extends ImageView implements Checkable {
	
	private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };
	
	private boolean mChecked;

	public CheckedImageView(Context context) {
		super(context);
	}

	public CheckedImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CheckedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }	

	@Override
	public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
        }		
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public void toggle() {
		setChecked(!mChecked);
	}

}
