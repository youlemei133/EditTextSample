package com.hudawei.edittextsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFocus();

        setCursor();
    }

    private void setCursor() {
        text_cursor=(EditText)findViewById(R.id.text_cursor);
        Button button_cursor=(Button)findViewById(R.id.button_cursor);
        button_cursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置光标是否可见
                text_cursor.setCursorVisible(true);
                //1.获取当前光标起始结束位置
                int startIndex=text_cursor.getSelectionStart();
                int endIndex=text_cursor.getSelectionEnd();

                Toast.makeText(MainActivity.this,"startIndex:"+startIndex+"   endIndex:"+endIndex,Toast.LENGTH_SHORT).show();
                //2.设置光标位置
                text_cursor.setSelection(startIndex>0?--startIndex:0,endIndex>0?--endIndex:0);
                //3.设置在获取焦点时全选
//                text_cursor.setSelectAllOnFocus(true);
            }
        });
    }

    private void setFocus() {
        EditText edit_focus=(EditText)findViewById(R.id.edit_focus);
        //设置获取焦点
        edit_focus.requestFocus();
    }
}
