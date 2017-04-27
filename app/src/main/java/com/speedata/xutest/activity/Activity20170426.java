package com.speedata.xutest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.speedata.xutest.R;

public class Activity20170426 extends AppCompatActivity implements View.OnClickListener {
    private TextView tvShow;
    private Button btnAnswer;
    private int aa, bb, cc, dd;
    private static int[] x1 = new int[]{15, 18, 21, 24};
    private static int[] y1 = new int[]{19, 23, 22, 18};
    private static int[] z1 = new int[]{26, 17, 16, 19};
    private static int[] s1 = new int[]{19, 21, 23, 17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_20170426);

        initView();
    }

    private void initView() {

        tvShow = (TextView) findViewById(R.id.tv_show);
        btnAnswer = (Button) findViewById(R.id.btn_answer);
        btnAnswer.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_answer:

                int sum = test();
                tvShow.setText("" + aa + "\n" + bb + "\n" + cc + "\n" + dd + "\n" + sum);
                break;
            default:
                break;
        }
    }

    private int test() {
        int a, b, c, d;
        int e;
        int sum = 10000;
        for (int i = 0; i < 4; i++) {
            int[] x = x1;
            int[] y = y1;
            int[] z = z1;
            int[] s = s1;
            a = x[i];
            for (int j = 0; j < 4; j++) {
             b = y[j];
                for (int k = 0; k < 4; k++) {
                  c = z[k];
                    for (int l = 0; l < 4; l++) {
                        d = s[l];
                        if (i != j && j != k && k != l && i != k && i != l && j != l) {
                            e = a + b + c + d;
                            if (e < sum) {
                                sum = e;
                                aa = a;
                                bb = b;
                                cc = c;
                                dd = d;
                            }
                        }

                    }

                }

            }

        }
        return sum;
    }

}
