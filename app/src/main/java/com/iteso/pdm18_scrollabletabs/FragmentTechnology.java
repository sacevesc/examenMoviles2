package com.iteso.pdm18_scrollabletabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by aceve on 02/03/2018.
 */

public class FragmentTechnology extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentTechnology() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_activity_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_mac), getResources().getString(R.string.tech_store_mac),getResources().getString(R.string.PHONE_MAC),getResources().getString(R.string.ADDRESS_MAC),getResources().getDrawable(R.drawable.mac),getResources().getDrawable(R.drawable.bestbuy)));
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_alien), getResources().getString(R.string.tech_store_alien),getResources().getString(R.string.PHONE_ALIEN),getResources().getString(R.string.ADDRESS_ALIEN),getResources().getDrawable(R.drawable.alienware),getResources().getDrawable(R.drawable.dell)));
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_lanix), getResources().getString(R.string.tech_Store_lanix),getResources().getString(R.string.PHONE_LANIX),getResources().getString(R.string.ADDRESS_LANIX),getResources().getDrawable(R.drawable.lanix),getResources().getDrawable(R.drawable.sanjuan)));

        AdapterProduct adapterProduct = new AdapterProduct(products);
        recyclerView.setAdapter(adapterProduct);
        return view;
    }

}
