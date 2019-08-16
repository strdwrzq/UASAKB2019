package xyz.kyrozyn.uasakb2019.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.kyrozyn.uasakb2019.R;
import xyz.kyrozyn.uasakb2019.model.Teman;

public class ListTemanAdapter extends RecyclerView.Adapter<ListTemanAdapter.ListViewHolder> {
    public static int position;
    private ArrayList<Teman> listTeman;
    private OnItemClickCallback onItemClickCallback;

    public ListTemanAdapter(ArrayList<Teman> listTeman) {
        this.listTeman = listTeman;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_teman, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int i) {
        Teman teman = listTeman.get(i);
        holder.tv_nama.setText(teman.getNama());
        holder.tv_nim.setText(teman.getNim());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTeman.size();
    }


    public interface OnItemClickCallback {
        void onItemClicked(int data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_nim;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_nim = itemView.findViewById(R.id.tv_nim);
        }
    }
}
