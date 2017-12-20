package com.yoprogramo.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setOnclickListener();

    }

    private void setOnclickListener() {
        button.setOnClickListener(onClickListener);

    }

    private void initWidget() {
        button = ((Button) findViewById(R.id.btn_run));
        time = ((EditText) findViewById(R.id.in_time));
        finalResult = ((TextView) findViewById(R.id.tv_result));
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AsyncTaskRunner runner = new AsyncTaskRunner(MainActivity.this,time, finalResult);
            runner.execute(time.getText().toString());
        }
    };

}
