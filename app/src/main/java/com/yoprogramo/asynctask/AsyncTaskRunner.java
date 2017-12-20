package com.yoprogramo.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yoprogramo on 12/19/2017.
 */

//                                             <Params, Progress, Result>
public class AsyncTaskRunner extends AsyncTask<String, String, String> {

    private Context context;
    private EditText editText;
    private TextView textView;
    private String resp;
    private ProgressDialog progressDialog;
    private String finalResult;

    public AsyncTaskRunner(Context context, EditText editText, TextView finalResult) {
        this.context = context;
        this.editText = editText;
        this.textView = finalResult;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,
                "ProgressDialog",
                "Wait for "+editText.getText().toString()+ " seconds");
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            publishProgress(params[0]);
            int time = Integer.parseInt(params[0]) * 1000;
            Thread.sleep(time);

            resp = "Slept for " + params[0] + " seconds";

        } catch (NumberFormatException | InterruptedException ie) {
           ie.printStackTrace();
            resp = ie.getMessage();
        }

        return resp;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressDialog.dismiss();
        textView.setText(result);

    }

}
