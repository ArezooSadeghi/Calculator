package com.example.calculator.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] mButtons = new Button[4][4];

    private Button mButtonDelete;

    private TextView mTextViewResult, mTextViewShowText;

    private double mNum1, mNum2;

    private boolean mAdd, mSub, mMul, mDiv;

    private static final String SHOW_TEXT = "SHOW_TEXT";
    private static final String RESULT_TEXT = "RESULT_TEXT";
    private static final String M_ADD = "M_ADD";
    private static final String M_SUB = "M_SUB";
    private static final String M_MUL = "M_MUL";
    private static final String M_DIV = "M_DIV";
    private static final String M_NUM_1 = "M_NUM_1";
    private static final String M_NUM_2 = "M_NUM_2";
    private String showText, resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        findViews();

        if (savedInstanceState != null) {
            showText = savedInstanceState.getString(SHOW_TEXT);
            resultText = savedInstanceState.getString(RESULT_TEXT);
            mAdd = savedInstanceState.getBoolean(M_ADD);
            mSub = savedInstanceState.getBoolean(M_SUB);
            mMul = savedInstanceState.getBoolean(M_MUL);
            mDiv = savedInstanceState.getBoolean(M_DIV);
            mNum1 = savedInstanceState.getDouble(M_NUM_1);
            mNum2 = savedInstanceState.getDouble(M_NUM_2);
        }

        mTextViewShowText.setText(showText);
        mTextViewResult.setText(resultText);

        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SHOW_TEXT, mTextViewShowText.getText().toString());
        outState.putString(RESULT_TEXT, mTextViewResult.getText().toString());
        outState.putBoolean(M_ADD, mAdd);
        outState.putBoolean(M_SUB, mSub);
        outState.putBoolean(M_MUL, mMul);
        outState.putBoolean(M_DIV, mDiv);
        outState.putDouble(M_NUM_1, mNum1);
        outState.putDouble(M_NUM_2, mNum2);
    }

    public void setListeners() {
        mButtonDelete.setOnClickListener(this);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mButtons[i][j].setOnClickListener(this);
            }
        }
    }

    public void findViews() {
        mButtons[0][0] = findViewById(R.id.btn_00);
        mButtons[0][1] = findViewById(R.id.btn_01);
        mButtons[0][2] = findViewById(R.id.btn_02);
        mButtons[0][3] = findViewById(R.id.btn_03);
        mButtons[1][0] = findViewById(R.id.btn_10);
        mButtons[1][1] = findViewById(R.id.btn_11);
        mButtons[1][2] = findViewById(R.id.btn_12);
        mButtons[1][3] = findViewById(R.id.btn_13);
        mButtons[2][0] = findViewById(R.id.btn_20);
        mButtons[2][1] = findViewById(R.id.btn_21);
        mButtons[2][2] = findViewById(R.id.btn_22);
        mButtons[2][3] = findViewById(R.id.btn_23);
        mButtons[3][0] = findViewById(R.id.btn_30);
        mButtons[3][1] = findViewById(R.id.btn_31);
        mButtons[3][2] = findViewById(R.id.btn_32);
        mButtons[3][3] = findViewById(R.id.btn_33);
        mButtonDelete = findViewById(R.id.btn_delete);
        mTextViewResult = findViewById(R.id.txt_resulttext);
        mTextViewShowText = findViewById(R.id.txt_showtext);
    }

    @Override
    public void onClick(View view) {
        String text = ((Button) view).getText().toString();
        switch (text) {
            case "+":
                mAdd = true;
                setText(view);
                break;
            case "-":
                mSub = true;
                setText(view);
                break;
            case "×":
                mMul = true;
                setText(view);
                break;
            case "÷":
                mDiv = true;
                setText(view);
                break;
            case "=":
                calcute();
                break;
            case "DELETE":
                delete();
                break;
            default:
                mTextViewResult.setText(mTextViewResult.getText() + " " + ((Button) view).getText().toString());
                mTextViewShowText.setText(mTextViewShowText.getText() + " " + ((Button) view).getText().toString());
                showToast((Button) view);
                break;
        }
    }

    private void calcute() {
        mNum2 = Double.parseDouble(mTextViewResult.getText() + "");
        if (mAdd) {
            mTextViewResult.setText(mNum1 + mNum2 + "");
            mTextViewShowText.setText(null);
            mAdd = !mAdd;
        }
        if (mSub) {
            mTextViewResult.setText(mNum1 - mNum2 + "");
            mTextViewShowText.setText(null);
            mSub = !mSub;
        }
        if (mMul) {
            mTextViewResult.setText(mNum1 * mNum2 + "");
            mTextViewShowText.setText(null);
            mMul = !mMul;
        }
        if (mDiv) {
            if (mNum2 == 0) {
                mTextViewResult.setText("خطا");
            } else {
                mTextViewResult.setText(mNum1 / mNum2 + "");
            }
            mTextViewShowText.setText(null);
            mDiv = !mDiv;
        }
    }

    public void setText(View view) {
        mNum1 = Double.parseDouble(mTextViewResult.getText() + "");
        mTextViewShowText.setText(mTextViewShowText.getText() + " " + ((Button) view).getText().toString());
        mTextViewResult.setText(null);
        showToast((Button) view);
    }

    public void delete() {
        String showText = mTextViewShowText.getText().toString();
        String deletedShowText = showText.substring(0, showText.length() - 1);
        String resultText = mTextViewResult.getText().toString();
        String deletedResultText = resultText.substring(0, resultText.length() - 1);
        mTextViewShowText.setText(deletedShowText);
        mTextViewResult.setText(deletedResultText);
    }

    private void showToast(Button view) {
        Toast toast = Toast.makeText(CalculatorActivity.this, view.getText().toString(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 60);
        toast.show();
    }
}