package com.xhy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_input;
    private TextView tv_output;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_div;
    private Button btn_mul;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_c;
    private Button btn_equal;

    private static StringBuilder str_show;
    //private static StringBuilder str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        str_show = new StringBuilder();
       // str = new StringBuilder();
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        tv_output = (TextView) findViewById(R.id.tv_ouput);
        tv_input = (TextView) findViewById(R.id.tv_input);

        btn_0.setOnClickListener(new BtnListener("0"));
        btn_1.setOnClickListener(new BtnListener("1"));
        btn_2.setOnClickListener(new BtnListener("2"));
        btn_3.setOnClickListener(new BtnListener("3"));
        btn_4.setOnClickListener(new BtnListener("4"));
        btn_5.setOnClickListener(new BtnListener("5"));
        btn_6.setOnClickListener(new BtnListener("6"));
        btn_7.setOnClickListener(new BtnListener("7"));
        btn_8.setOnClickListener(new BtnListener("8"));
        btn_9.setOnClickListener(new BtnListener("9"));
        btn_add.setOnClickListener(new BtnListener("+"));
        btn_sub.setOnClickListener(new BtnListener("-"));
        btn_mul.setOnClickListener(new BtnListener("*"));
        btn_div.setOnClickListener(new BtnListener("/"));

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_show=new StringBuilder();
                //str.delete(0,str_show.length()-1);
                tv_input.setText("");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HouZhui hz = new HouZhui(str_show.toString());

                tv_output.setText(String.valueOf(hz.getJiSuan()));

            }
        });


    }


    private class BtnListener implements View.OnClickListener {

        private String s;

        public BtnListener(String s) {

            this.s = s;

        }

        @Override
        public void onClick(View v) {

            switch (s){

                case "0":
                    //str.append("0;");
                    str_show.append("0");
                    break;
                case "1":
                    //str.append("1;");
                    str_show.append("1");
                    break;
                case "2":
                    //str.append("2;");
                    str_show.append("2");
                    break;
                case "3":
                    //str.append("3;");
                    str_show.append("3");
                    break;
                case "4":
                    //str.append("4;");
                    str_show.append("4");
                    break;
                case "5":
                    //str.append("5;");
                    str_show.append("5");
                    break;
                case "6":
                    //str.append("6;");
                    str_show.append("6");
                    break;
                case "7":
                    //str.append("7;");
                    str_show.append("7");
                    break;
                case "8":
                    //str.append("8;");
                    str_show.append("8");
                    break;
                case "9":
                    //str.append("9;");
                    str_show.append("9");
                    break;
                case "+":
                    //str.append("+;");
                    str_show.append("+");
                    break;
                case "-":
                    //str.append("-;");
                    str_show.append("-");
                    break;
                case "*":
                    //str.append("*;");
                    str_show.append("*");
                    break;
                case "/":
                    //str.append("/;");
                    str_show.append("/");
                    break;
                case ".":
                    //str.append(".");
                    str_show.append(".");
                    break;


            }


            //Log.v("aa",str_show);
            tv_input.setText(str_show);

        }
    }
}
