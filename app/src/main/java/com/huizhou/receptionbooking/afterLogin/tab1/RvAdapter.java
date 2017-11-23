package com.huizhou.receptionbooking.afterLogin.tab1;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huizhou.receptionbooking.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String> mTitle;

    private OnItemClickListener mOnItemClickListener;

    public RvAdapter(Context context, List<String> title)
    {
        mContext = context;
        mTitle = title;
        mLayoutInflater = LayoutInflater.from(context);
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class NormalViewHolder extends RecyclerView.ViewHolder
    {
        public  TextView mTextView;
        public  CardView mCardView;

        public NormalViewHolder(View itemView)
        {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_text);
            mCardView = (CardView) itemView.findViewById(R.id.cv_item);
        }
    }

    //在该方法中我们创建一个ViewHolder并返回，ViewHolder必须有一个带有View的构造函数，这个View就是我们Item的根布局，在这里我们使用自定义Item的布局；
    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mLayoutInflater.inflate(R.layout.rv_item, parent, false);
        NormalViewHolder vh = new NormalViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        NormalViewHolder viewholder = (NormalViewHolder) holder;
        viewholder.mTextView.setText(mTitle.get(position));

        viewholder.itemView.setTag(viewholder);
        viewholder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mOnItemClickListener.onItemClick(v);
            }
        });

    }

    //获取数据的数量
    @Override
    public int getItemCount()
    {
        return mTitle == null ? 0 : mTitle.size();
    }

    //define interface
    public interface OnItemClickListener
    {
        void onItemClick(View view);
    }


    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mOnItemClickListener = listener;
    }

}
