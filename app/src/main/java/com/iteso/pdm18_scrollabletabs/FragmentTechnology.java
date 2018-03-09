package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by aceve on 02/03/2018.
 */

public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ItemProduct> products;
    public FragmentTechnology() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_activity_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<>();
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_mac), getResources().getString(R.string.tech_store_mac),getResources().getString(R.string.PHONE_MAC),getResources().getString(R.string.ADDRESS_MAC),0,0,0));
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_alien), getResources().getString(R.string.tech_store_alien),getResources().getString(R.string.PHONE_ALIEN),getResources().getString(R.string.ADDRESS_ALIEN),1,1,1));
        products.add(new ItemProduct(getResources().getString(R.string.tech_title_lanix), getResources().getString(R.string.tech_Store_lanix),getResources().getString(R.string.PHONE_LANIX),getResources().getString(R.string.ADDRESS_LANIX),2,2,2));

        mAdapter = new AdapterProduct(getActivity(),products);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> iterator = products.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                products.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
