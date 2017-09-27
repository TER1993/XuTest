package com.speedata.xutest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.speedata.xutest.R;


/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 *
 * @author Reginer on  2016/10/14 13:36.
 *         Description:text+edit子项View
 */
public class TextEditView extends LinearLayout {

    private TextView mTitle;
    private EditText mContent;

    public TextEditView(Context context) {
        this(context, null);
    }

    public TextEditView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_text_edit_item_layout, this, true);
        mTitle = (TextView) findViewById(R.id.tv_item_title);
        mContent = (EditText) findViewById(R.id.et_item_content);
    }

    /**
     * 设置控件标题
     *
     * @param title 标题
     */
    public void setViewTitle(int title) {
        mTitle.setText(title);
    }

    /**
     * 设置控件内容
     *
     * @param content 内容
     */
    public void setViewContent(CharSequence content) {
        mContent.setText(content);
    }

    /**
     * 获取控件内容
     */
    public String getViewContent() {
      return mContent.getText().toString();
    }

    /**
     *控件是否可以点击修改内容
     */
    public void setViewEnable(boolean mBoolean) {

        if (mBoolean) {
            mContent.setEnabled(true);

        } else {
            mContent.setEnabled(false);
        }

    }

}