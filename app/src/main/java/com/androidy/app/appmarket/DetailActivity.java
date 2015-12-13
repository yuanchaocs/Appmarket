package com.androidy.app.appmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(myAdapter);
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public int viewType;
        public TextView tv_text;
        public ImageView iv_img;

        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }


    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public int getItemViewType(int position) {
            return position % 3;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = null;
            switch (viewType) {
                case 0:
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview0, null);
                    break;
                case 1:
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview1, null);
                    break;
                case 2:
                    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview2, null);
                    break;
            }
            return new MyViewHolder(itemView, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            int viewType = myViewHolder.viewType;
            myViewHolder.tv_text.setText(viewType + " 测试数据 " + position);
        }

        @Override
        public int getItemCount() {
            return 50;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
