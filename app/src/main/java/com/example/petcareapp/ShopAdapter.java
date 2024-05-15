package com.example.petcareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private Context context;
    private List<item> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(item item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ShopAdapter(Context context, List<item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item currentItem = itemList.get(position);
        holder.textviewitemname.setText(currentItem.getName());
        holder.textviewitemprice.setText(currentItem.getPrice());
        holder.imageviewitem.setImageResource(currentItem.getImage());

        holder.buttonitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(itemList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageviewitem;
        TextView textviewitemname;
        TextView textviewitemprice;
        Button buttonitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageviewitem = itemView.findViewById(R.id.imageviewitem);
            textviewitemname = itemView.findViewById(R.id.textviewitemname);
            textviewitemprice = itemView.findViewById(R.id.textviewitemprice);
            buttonitem = itemView.findViewById(R.id.buttonitem);
        }
    }
}

