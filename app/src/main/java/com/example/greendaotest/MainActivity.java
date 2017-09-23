package com.example.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mResult;
    private EditText age;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.add);
        Button delete = (Button) findViewById(R.id.delete);
        Button update = (Button) findViewById(R.id.update);
        Button query = (Button) findViewById(R.id.query);
        Button queryOne = (Button) findViewById(R.id.queryOne);
        mResult = (TextView) findViewById(R.id.result);
        age = (EditText) findViewById(R.id.input_age);
        name = (EditText) findViewById(R.id.input_name);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
        queryOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                String username = name.getText().toString().trim();
                String userage = age.getText().toString().trim();
                User user = new User(username, userage);
                DataBaseManager.getInstance().insertUser(user);
                break;
            case R.id.delete:

                break;
            case R.id.update:
                User user1 = new User("aa", "20");
                DataBaseManager.getInstance().updateUser(user1, "30");
                break;
            case R.id.query:
                List<String> strings = DataBaseManager.getInstance().queryAllUser();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < strings.size(); i++) {
                    sb.append(strings.get(i) + ",");
                }
                mResult.setText(sb.toString());
                break;
            case R.id.queryOne: //按条件查询
                String queryname = name.getText().toString().trim();
                List<String> s = DataBaseManager.getInstance().queryOne(queryname);
                StringBuffer sbs = new StringBuffer();
                for (String str : s) {
                    sbs.append(str + ",");
                }
                mResult.setText(sbs.toString());
                break;
            default:
                break;
        }
    }
}
