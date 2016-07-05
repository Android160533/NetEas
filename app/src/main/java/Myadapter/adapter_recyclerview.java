package Myadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import bean.msg;

/**
 * Created by Administrator on 16-7-4.
 */
public class adapter_recyclerview extends RecyclerView.Adapter{
    private List<bean.msg>list;
    private Context context;
    private LayoutInflater inflater;

    public adapter_recyclerview(List<msg> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
    }

    @Override
    public int getItemCount(){
        return 0;
    }
}
