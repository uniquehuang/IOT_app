package com.zjxu.hwl.ui.main.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zjxu.hwl.R;
import com.zjxu.hwl.entity.HolderDeviceEntity;
import com.zjxu.hwl.entity.MessageEntity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>implements View.OnClickListener{
    private final Context mContext;
    private final ArrayList<MessageEntity> mData;
    private OnItemClickListener onItemClickListener;

    public MessageAdapter(Context mContext) {
        this.mContext = mContext;
        this.mData=new ArrayList<MessageEntity>();
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_message_item,parent,false);
        view.setOnClickListener(this);
        return new MessageViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NotNull MessageAdapter.MessageViewHolder holder, int position) {
        //设置数据
        holder.itemView.setTag(position);
        MessageEntity messageEntity = mData.get(position);
//        holder.tv_name.setText(deviceEntity.getTitle());
//        holder.tv_desc.setText(deviceEntity.getDescription());
        //此处被修改
        Glide.with(mContext)
                .load(messageEntity.getImg())
                .into(holder.iv_image);

    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void resetDataAndNotifyDataSetChanged(List<MessageEntity> data){
        if (data != null && data.size() != 0){
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public void onClick(View v) {
        if (onItemClickListener != null){
            int pos = (int) v.getTag();
            MessageEntity messageEntity = mData.get(pos);
            onItemClickListener.onItemClick(pos,messageEntity);
        }
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image)
        ImageView iv_image;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_desc)
        TextView tv_desc;


        public MessageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener =  listener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position, MessageEntity item);
    }
}
