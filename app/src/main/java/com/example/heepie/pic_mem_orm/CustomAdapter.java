package com.example.heepie.pic_mem_orm;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heepie.pic_mem_orm.model.PicNote;

import java.util.List;

/**
 * Created by Heepie on 2017. 9. 22..
 */

/**
 * 리사이클러 아뎁터
 */
public class CustomAdapter extends RecyclerView.Adapter<Holder> {
    List<PicNote> data;

    // 데이터 등록
    public void setData(List<PicNote> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.item_list, parent, false);

        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        PicNote picNote = data.get(position);
        holder.setTitle(picNote.getTitle());
        holder.setContent(picNote.getContent());
    }
}

class Holder extends RecyclerView.ViewHolder {
    private TextView textTitle;
    private TextView textContent;

    public Holder(View itemView) {
        super(itemView);

        textTitle = itemView.findViewById(R.id.textTitle);
        textContent = itemView.findViewById(R.id.textContent);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    public void setTitle(String str) {
        textTitle.setText(str);
    }

    public void setContent(String str) {
        textContent.setText(str);
    }
}
