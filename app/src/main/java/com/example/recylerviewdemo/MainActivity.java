package com.example.recylerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MessageItem> messageItemList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgItems();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MsgItemAdapter adapter=new MsgItemAdapter(messageItemList,this);
        recyclerView.setAdapter(adapter);
    }
    private void initMsgItems(){
        for(int i=0;i<30;i++){
            MessageItem messageItem=new MessageItem("杜甫","诗圣","刚刚",R.drawable.dufu);
            messageItemList.add(messageItem);
        }
    }
}
