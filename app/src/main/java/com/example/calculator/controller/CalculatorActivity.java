package com.example.calculator.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;

public class CalculatorActivity extends AppCompatActivity {

    public static final String MADD = "MADD";
    public static final String MSUB = "MSUB";
    public static final String MMUL = "MMUL";
    public static final String MDIV = "MDIV";
    private Button mButton0, mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9,
    mButtonPoint, mButtonAdd, mButtonSub, mButtonMul, mButtonDiv, mButtonEqual, mButtonDelete;

    private TextView mTextViewResult;

    double mNum1, mNum2;

    boolean mAdd, mSub, mMul, mDiv;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        findViews();

        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(MADD, mAdd);
        outState.putBoolean(MSUB, mSub);
        outState.putBoolean(MMUL, mMul);
        outState.putBoolean(MDIV, mDiv);
    }

    public void findViews() {
       mButton0 = findViewById(R.id.btn_0);
       mButton1 = findViewById(R.id.btn_1);
       mButton2 = findViewById(R.id.btn_2);
       mButton3 = findViewById(R.id.btn_3);
       mButton4 = findViewById(R.id.btn_4);
       mButton5 = findViewById(R.id.btn_5);
       mButton6 = findViewById(R.id.btn_6);
       mButton7 = findViewById(R.id.btn_7);
       mButton8 = findViewById(R.id.btn_8);
       mButton9 = findViewById(R.id.btn_9);
       mButtonPoint = findViewById(R.id.btn_point);
       mButtonEqual = findViewById(R.id.btn_equal);
       mButtonSub = findViewById(R.id.btn_sub);
       mButtonAdd = findViewById(R.id.btn_add);
       mButtonMul = findViewById(R.id.btn_mul);
       mButtonDiv = findViewById(R.id.btn_div);
       mButtonDelete = findViewById(R.id.btn_delete);
       mTextViewResult = findViewById(R.id.txt_resulttext);
    }

    public void setListeners() {
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mTextViewResult.setText(mTextViewResult.getText() + "0");
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "1");
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "2");
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "3");
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "4");
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "5");
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "6");
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "7");
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "8");
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + "9");
            }
        });

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdd = true;
                mNum1 = Double.parseDouble(mTextViewResult.getText()+"");
                mTextViewResult.setText(null);
            }
        });

        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSub = true;
                mNum1 = Double.parseDouble(mTextViewResult.getText()+"");
                mTextViewResult.setText(null);
            }
        });

        mButtonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMul = true;
                mNum1 = Double.parseDouble(mTextViewResult.getText()+"");
                mTextViewResult.setText(null);
            }
        });

        mButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDiv = true;
                mNum1 = Double.parseDouble(mTextViewResult.getText()+"");
                mTextViewResult.setText(null);
            }
        });

        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResult.setText(mTextViewResult.getText() + ".");
            }
        });

        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum2 = Double.parseDouble(mTextViewResult.getText()+"");
                if (mAdd) {
                    mTextViewResult.setText(mNum1 + mNum2 + "");
                    mAdd = false;
                }
                if (mSub) {
                    mTextViewResult.setText(mNum1 - mNum2 + "");
                    mSub = false;
                }
                if (mMul) {
                    mTextViewResult.setText(mNum1 * mNum2 + "");
                    mMul = false;
                }
                if (mDiv) {
                    mTextViewResult.setText(mNum1 / mNum2 + "");
                    mDiv = false;
                }

            }
        });

    }

}