package com.example.retrofitapipractice;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ViewInterface{
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MyDataClass myDataClass=new MyDataClass(this);

        DataModal modal=new DataModal();
        modal.getUpComingMovies(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data....");
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading!");
        progressDialog.show();

        //   myDataClass.readDataFromServer();

        }

   /* @Override
    public void loadData(ArrayList<Posts> data) {
        progressDialog.hide();
        LinearLayout linearLayout=findViewById(R.id.linearLayout1);
        for(int i=0;i<data.size();i++){
            LayoutInflater inflater=LayoutInflater.from(this);
            View view=inflater.inflate(R.layout.myview,null);
            TextView textView1=view.findViewById(R.id.text1);
            TextView textView2=view.findViewById(R.id.text2);
            textView1.setText(data.get(i).title);
            textView2.setText(data.get(i).body);
            linearLayout.addView(view);
        }
}
   */
    @Override
    public void loadData(AllMovies allMovies) {
        progressDialog.hide();
        MyBaseAdapter adp=new MyBaseAdapter(this,allMovies);
        GridView gridView=findViewById(R.id.gridView);
        gridView.setAdapter(adp);

        //ListView listView=findViewById(R.id.listView);
        //listView.setAdapter(adp);
    }
}