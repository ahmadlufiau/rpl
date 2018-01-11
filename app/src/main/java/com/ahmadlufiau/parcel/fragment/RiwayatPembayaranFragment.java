package com.ahmadlufiau.parcel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadlufiau.parcel.R;
import com.ahmadlufiau.parcel.adapter.RiwayatPembayaranAdapter;
import com.ahmadlufiau.parcel.pojo.RiwayatPembayaranPojo;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatPembayaranFragment extends AppCompatActivity {

    private RecyclerView rvAndroid;
    private List<RiwayatPembayaranPojo> list;
    private RecyclerView.ItemDecoration decoration;


    public RiwayatPembayaranFragment() {
        // Required empty public constructor
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_riwayat_pembayaran);
        setupEnv();
        setupList();
        loadDataDummy();
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riwayat_pembayaran, container, false);
        setupEnv();
        setupList();
        loadDataDummy();
        return view;
    }
    */

    private void setupEnv() {
        rvAndroid = (RecyclerView) findViewById(R.id.rvAndroid);

        list = new ArrayList<>();
        decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
    }


    private void setupList() {
        RiwayatPembayaranAdapter adapter = new RiwayatPembayaranAdapter(list);
        rvAndroid.setLayoutManager(new LinearLayoutManager(this));
        rvAndroid.addItemDecoration(decoration);
        rvAndroid.setAdapter(adapter);
    }

    private void loadDataDummy() {
        list.add(new RiwayatPembayaranPojo(
                R.drawable.ic_history_black_24dp,
                "35421",
                "Pembayaran Selesai",
                "2018-01-1",
                "",
                "Detail"
        ));

        list.add(new RiwayatPembayaranPojo(
                R.drawable.ic_history_black_24dp,
                "35425",
                "Pembayaran Selesai",
                "2018-01-2",
                "",
                "Deskripsi Detail"
        ));
    }

}
