package com.example.administrator.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListAdapterActivity extends Activity {

    private static final String[] strs = new String[] {
        "first", "second", "third", "fourth", "fifth"
    };//定义一个String数组用来显示ListView的内容private ListView lv;/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter);

        ListView lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}
