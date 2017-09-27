package com.speedata.xutest.add;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.speedata.xutest.R;


/**
 * @author :Reginer in  2017/9/21 17:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AddAssetsView extends LinearLayout {

    private EditText mContentView;

    public AddAssetsView(Context context) {
        this(context, null);
    }

    public AddAssetsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddAssetsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.view_widget_add_assets_layout, this, true);
        TextView mTitleView = findViewById(R.id.tv_title);
        mContentView = findViewById(R.id.et_content);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.AddAssetsView);
        if (attributes != null) {
            String title = attributes.getString(R.styleable.AddAssetsView_av_title);
            if (!TextUtils.isEmpty(title))
                mTitleView.setText(title);
            boolean clickable = attributes.getBoolean(R.styleable.AddAssetsView_av_clickable, true);
            mContentView.setEnabled(clickable);
            int type = attributes.getInt(R.styleable.AddAssetsView_et_type, 1);
            if (type == 0) {
                mContentView.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else if (type == 1) {
                mContentView.setInputType(InputType.TYPE_CLASS_TEXT);
            } else if (type == 2) {
                mContentView.setInputType(InputType.TYPE_CLASS_DATETIME);
            }
            attributes.recycle();
        }
    }

    public String getText() {
        return mContentView.getText().toString();
    }

    public void setText(CharSequence text) {
        mContentView.setText(text);
    }

}
