package com.example.practical_round;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Callback;

public class DataAdpter extends RecyclerView.Adapter<DataAdpter.DataViewHolder> {

    List<Data.Datum> userlist;
    Context context;

    public DataAdpter(Callback<List<Data>> userlist, List<Data> context) {
        this.userlist = (List<Data.Datum>) userlist;
        this.context = (Context) context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_data,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        Data.Datum data=userlist.get(position);

        Glide.with(context).load(userlist.get(position)).into(holder.imageView);

        holder.id.setText(data.getId());
        holder.email.setText(data.getEmail());
       holder.first_name.setText(data.getFirstName());
       holder.last_name.setText(data.getLastName());


    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        TextView id,email,first_name,last_name;
        ImageView imageView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            email=itemView.findViewById(R.id.email);
            first_name=itemView.findViewById(R.id.firstName);
            last_name=itemView.findViewById(R.id.lastName);
            imageView=imageView.findViewById(R.id.userImage);
        }
    }
}
