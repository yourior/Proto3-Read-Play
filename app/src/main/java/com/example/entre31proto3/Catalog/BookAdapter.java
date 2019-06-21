package com.example.entre31proto3.Catalog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entre31proto3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Book> rogerModelArrayList;

    public BookAdapter(Context ctx, ArrayList<Book> rogerModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.rogerModelArrayList = rogerModelArrayList;
    }

    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(BookAdapter.MyViewHolder holder, int position) {

//        Picasso.get().load(rogerModelArrayList.get(position).getImgURL()).into(holder.iv);
//        holder.name.setText(rogerModelArrayList.get(position).getName());
//        holder.country.setText(rogerModelArrayList.get(position).getCountry());
//        holder.city.setText(rogerModelArrayList.get(position).getCity());
        Picasso.get().load(rogerModelArrayList.get(position).getImg_Location()).into(holder.iv);
        holder.name.setText(rogerModelArrayList.get(position).getBook_Name());
        holder.price.setText(Integer.toString(rogerModelArrayList.get(position).getBook_Price()));
        holder.creator.setText(rogerModelArrayList.get(position).getCreator());
    }

    @Override
    public int getItemCount() {
        return rogerModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

//       ImageView iv;
//       TextView name,country,city;
//
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//
//            country = (TextView) itemView.findViewById(R.id.country);
//            name = (TextView) itemView.findViewById(R.id.name);
//            city = (TextView) itemView.findViewById(R.id.city);
//            iv = (ImageView) itemView.findViewById(R.id.iv);
//        }
        ImageView iv;
        TextView name,price,creator;


        public MyViewHolder(View itemView) {
            super(itemView);

            price = (TextView) itemView.findViewById(R.id.price);
            name = (TextView) itemView.findViewById(R.id.name);
            creator = (TextView) itemView.findViewById(R.id.creator);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
