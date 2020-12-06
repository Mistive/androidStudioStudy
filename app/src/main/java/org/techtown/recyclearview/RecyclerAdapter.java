package org.techtown.recyclearview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



class RecyclerViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textView1, textView2;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.img);
        textView1 = itemView.findViewById(R.id.tv1);
        textView2 = itemView.findViewById(R.id.tv2);
    }
}

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    List<Item> list;

    private static Toast sToast;
    public static void showToast(Context context, String message) {
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }


    public RecyclerAdapter(List<Item> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.imageView.setImageResource(list.get(position).image);
        holder.textView1.setText(list.get(position).tv1);
        holder.textView2.setText(list.get(position).tv2);

        holder.textView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showToast(view.getContext(), list.get(position).tv1);
//                Toast.makeText(view.getContext(), list.get(position).tv1, Toast.LENGTH_SHORT).show();
            }
        });

        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(view.getContext(), list.get(position).tv2);
//                Toast.makeText(view.getContext(), list.get(position).tv2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
