package com.ahmadlufiau.parcel.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadlufiau.parcel.R;
import com.ahmadlufiau.parcel.helper.DateTimeFormat;
import com.ahmadlufiau.parcel.pojo.RiwayatPembayaranPojo;

import java.util.List;

/**
 * Created by Ahmad Lufi A U on 10/01/2018.
 */

public class RiwayatPembayaranAdapter extends RecyclerView.Adapter<RiwayatPembayaranAdapter.ViewHolder> {

    private List<RiwayatPembayaranPojo> list;

    public RiwayatPembayaranAdapter(List<RiwayatPembayaranPojo> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_riwayat_pembayaran, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView kp;
        TextView initialDate;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.iv_picture);
            kp = (TextView) itemView.findViewById(R.id.tv_kp);
            initialDate = (TextView) itemView.findViewById(R.id.tv_initial_date);
        }

        public void bind(final RiwayatPembayaranPojo item) {
            picture.setImageResource(item.getPicture());
            kp.setText(item.getKp() + " (" + item.getVersion() + ")");
            initialDate.setText(DateTimeFormat.getDateString(item.getInitialDate()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    //intent.putExtra(DetailActivity.SCREENSHOT, item.getScreenshot());
                    //intent.putExtra(DetailActivity.DESCRIPTION, item.getDescription());
                    //itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
