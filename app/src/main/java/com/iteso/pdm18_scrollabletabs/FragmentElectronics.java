package com.iteso.pdm18_scrollabletabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.database.DataBaseHandler;
import com.iteso.pdm18_scrollabletabs.database.ItemProductControl;

import java.util.ArrayList;

/**
 * Created by aceve on 02/03/2018.
 */

public class FragmentElectronics extends Fragment {
    ArrayList<ItemProduct> products;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentElectronics() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_electronics, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ItemProductControl itemProductControl = new ItemProductControl();
        products = new ArrayList<>();
        products = itemProductControl.getItemProductsByCategory(3, DataBaseHandler.getInstance(getActivity()));
        mAdapter = new AdapterProduct(getActivity(), products);
        recyclerView.setAdapter(mAdapter);
        itemProductControl = null;
        return view;
    }

    public void notifyDataSetChanged(ItemProduct itemProduct) {
        products.add(itemProduct);
        mAdapter.notifyDataSetChanged();
    }
}
 /*    RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<>();
        products.add(new ItemProduct(getResources().getString(R.string.electronics_title),
                getResources().getString(R.string.electronics_store),
                getResources().getString(R.string.electronics_phone),
                getResources().getString(R.string.electronics_address),
                5,5,
                5));



        mAdapter = new AdapterProduct(getActivity(),products);
        recyclerView.setAdapter(mAdapter);
     */