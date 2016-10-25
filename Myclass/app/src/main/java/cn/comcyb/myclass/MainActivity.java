package cn.comcyb.myclass;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout srl;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> lists  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lists.add("2");
        listView = (ListView) this.findViewById(R.id.lv);
        srl = (SwipeRefreshLayout) this.findViewById(R.id.srl);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lists);
        listView.setAdapter(arrayAdapter);
        /*MyTopBar bar = (MyTopBar) this.findViewById(R.id.mytopbar);
        bar.setOnClickListener(new MyTopBar.CallBackListener() {
            @Override
            public void leftListener(View v) {
                Toast.makeText(MainActivity.this, "臭傻逼点击了左边", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightListener(View v) {
                Toast.makeText(MainActivity.this, "臭傻逼点击了右边", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    /**下拉刷新**/
    @Override
    public void onRefresh() {
        lists.add((lists.size()+1)+"");
        arrayAdapter.notifyDataSetChanged();
    }
}
