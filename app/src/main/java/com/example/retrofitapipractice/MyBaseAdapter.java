package com.example.retrofitapipractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MyBaseAdapter extends BaseAdapter {

    Context ctx;
    AllMovies movies;

    MyBaseAdapter(Context context, AllMovies allMovies){
        ctx=context;
        movies=allMovies;
    }
    @Override
    public int getCount() {
        return movies.results.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myview=null;
        LayoutInflater inflater=LayoutInflater.from(ctx);
        myview=inflater.inflate(R.layout.myview,null);
        ImageView imageView=myview.findViewById(R.id.imageView);
        System.out.println("http://image.tmdb.org/t/p/w185"+movies.results.get(position).poster_path);
        Picasso.get().load("https://image.tmdb.org/t/p/w185"+movies.results.get(position).poster_path).into(imageView);

        return myview;
    }
}
