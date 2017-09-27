package com.speedata.xutest.main.sync;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.speedata.xutest.R;


/**
 * @author :Reginer in  2017/9/20 14:26.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SyncItemView extends RelativeLayout {
    private ProgressBar mBar;
    private CheckBox mBox;
    private ImageView mImgStatus;

    public SyncItemView(Context context) {
        this(context, null);
    }

    public SyncItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SyncItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_sync_item_layout, this, true);
        mBox = findViewById(R.id.cb_title);
        mBar = findViewById(R.id.progress);
        mImgStatus = findViewById(R.id.img_status);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SyncItemView);
        if (attributes != null) {
            String title = attributes.getString(R.styleable.SyncItemView_cb_title);
            if (!TextUtils.isEmpty(title))
                mBox.setText(title);
            boolean isShow = attributes.getBoolean(R.styleable.SyncItemView_p_visible, true);
            mBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
            attributes.recycle();
        }
    }

    public void setProgressVisible(boolean isShow) {
        mBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public boolean isChecked() {
        return mBox.isChecked();
    }

    public void setComplete(boolean right) {
        mImgStatus.setVisibility(View.VISIBLE);
        mImgStatus.setImageResource(right ? R.drawable.ic_right : R.drawable.ic_wrong);
    }
}
