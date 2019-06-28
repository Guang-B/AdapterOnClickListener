package com.gzeinnumer.adapteronclicklistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//todo 4
public class AdapterRv extends RecyclerView.Adapter<AdapterRv.MyHolder>{

    private Context context;
    private String[] data;

    //todo 10
    private onItemClick click;

    //todo 11
    public interface onItemClick {
        void onItemClick(int position, String data);
    }

    //todo 12
    public void setOnClickListener2(onItemClick onClick) {
        click = onClick;
    }

    public AdapterRv(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //todo 5 buat file xml
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        //todo 9
        holder.tv.setText(data[position]);

        //todo 13
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onItemClick(position, data[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        //todo 8
        return data.length;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        //todo 7
        TextView tv;
        MyHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_text);
        }
    }
}
