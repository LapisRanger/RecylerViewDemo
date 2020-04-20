package com.example.recylerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MsgItemAdapter extends RecyclerView.Adapter<MsgItemAdapter.ViewHolder> {
    private List<MessageItem> mMsgList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView headImage;
        TextView name;
        TextView text;
        TextView sendTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headImage= (RoundedImageView) itemView.findViewById(R.id.imageView);
            name=(TextView)itemView.findViewById(R.id.name);
            text=(TextView)itemView.findViewById(R.id.sendText);
            sendTime=(TextView)itemView.findViewById(R.id.sendTime);
        }
    }

    public MsgItemAdapter(List<MessageItem> mMsgList,Context context) {
        this.mMsgList = mMsgList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final MessageItem messageItem=mMsgList.get(position);
        holder.headImage.setImageResource(messageItem.getImgId());
        holder.name.setText(messageItem.getName());
        holder.text.setText(messageItem.getText());
        holder.sendTime.setText(messageItem.getSendTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Main2Activity.class);
                Bundle data=new Bundle();
                String info="Item"+ position;

                data.putString("info",info);
                intent.putExtra("data",data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

}
