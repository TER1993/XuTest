package com.speedata.xutest.activity.mvptest;

import android.content.Context;
import android.widget.AutoCompleteTextView;

/**
 *
 * @author xu
 * @date 2017/11/8
 */

public interface Login2Presenter {
      void presenterLogin(boolean isDefault);
      void autoMessage(Context context, String add);
      void autoInit(Context context, AutoCompleteTextView auto);
      void autoClear(Context context);

}
