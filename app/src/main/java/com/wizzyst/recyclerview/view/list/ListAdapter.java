package com.wizzyst.recyclerview.view.list;
/*=============================*/
/*            AUTHOR           */
/*          JULIAN NR          */
/* juliannoorrizani@gmail.com  */
/*         21 Nov 2019         */
/*=============================*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wizzyst.recyclerview.R;
import com.wizzyst.recyclerview.data.User;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<User> data = new ArrayList<>();

    void insertData(List<User> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * method ini yang akan membuat viewholder pada setiap item sekaligus meng-inflate layout yang digunakan
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    /**
     * method yang akan mengikat data item sesuai dengah posisi item pada list
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    /**
     * penting, jumlah item yang tampil pada list tergantung return dari method ini
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvAge;
        private TextView tvAddress;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }

        void bind(User item) {
            tvName.setText(item.getName());
            tvAge.setText(String.format("%s Years Old", item.getAge()));
            tvAddress.setText(item.getAddress());
        }
    }
}
