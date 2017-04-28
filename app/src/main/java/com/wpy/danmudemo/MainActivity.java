package com.wpy.danmudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.wpy.danmudemo.danmu.DanmuControl;
import com.wpy.danmudemo.listview.ListViewAdapter;
import com.wpy.danmudemo.model.Danmu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import master.flame.danmaku.controller.IDanmakuView;

public class MainActivity extends AppCompatActivity {

    private IDanmakuView mDanmakuView;
    private DanmuControl mDanmuControl;

    private Button btnAddDanmu;
    private ListView mListView;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDanmuControl = new DanmuControl(this);
        initView();
    }

    private void initView() {
        mDanmakuView = (IDanmakuView) findViewById(R.id.danmakuView);
        btnAddDanmu = (Button) findViewById(R.id.btnAddDanmu);
        mListView = (ListView) findViewById(R.id.list_view);

        mListViewAdapter = new ListViewAdapter(getApplicationContext());
        mListView.setAdapter(mListViewAdapter);

        mDanmuControl.setDanmakuView(mDanmakuView);
        btnAddDanmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });
    }

    private void setData() {
        List<Danmu> danmus = new ArrayList<>();
        Danmu danmu1 = new Danmu(0, 1, "Like", R.mipmap.ic_default_header, "");
        Danmu danmu2 = new Danmu(0, 2, "Comment", R.mipmap.ic_default_header, "这是一条弹幕啦啦啦");
        Danmu danmu3 = new Danmu(0, 3, "Like", R.mipmap.ic_default_header, "");
        Danmu danmu4 = new Danmu(0, 1, "Comment", R.mipmap.wat, "这又是一条弹幕啦啦啦");
        Danmu danmu5 = new Danmu(0, 2, "Like", R.mipmap.girl, "");
        Danmu danmu6 = new Danmu(0, 3, "Comment", R.mipmap.wat, "这还是一条弹幕啦啦啦");
        Danmu danmu7 = new Danmu(0, 3, "Comment", R.mipmap.wat, "腾讯动漫，不错哦");
        Danmu danmu8 = new Danmu(0, 3, "Comment", R.mipmap.wat, "腾讯动漫，我稀罕");
        danmus.add(danmu1);
        danmus.add(danmu2);
        danmus.add(danmu3);
        danmus.add(danmu4);
        danmus.add(danmu5);
        danmus.add(danmu6);
        danmus.add(danmu7);
        danmus.add(danmu8);
        Collections.shuffle(danmus);
        mDanmuControl.addDanmuList(danmus);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDanmuControl.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDanmuControl.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDanmuControl.destroy();
    }
}
