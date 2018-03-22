package com.iteso.pdm18_scrollabletabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;


public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> products) {
        this.products = products;
        this.context=context;
    }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mAddress.setText(products.get(holder.getAdapterPosition()).getStore().getCity().getName());
            holder.mTitle.setText(products.get(position).getTitle());
            holder.mStore.setText(products.get(holder.getAdapterPosition()).getStore().getName());
            holder.mPhone.setText(products.get(position).getStore().getPhone());
            holder.mPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:" + products.get(position).getStore().getPhone()));
                    context.startActivity(intent);
                }
            });


            switch (products.get(position).getImage()) {
                case 0: holder.mImage.setImageResource(R.drawable.mac); break;
                case  1: holder.mImage.setImageResource(R.drawable.alienware); break;
                case  2: holder.mImage.setImageResource(R.drawable.lanix); break;
                case  3: holder.mImage.setImageResource(R.drawable.lampara); break;
                case  4: holder.mImage.setImageResource(R.drawable.planta); break;
                case  5: holder.mImage.setImageResource(R.drawable.phone); break;
                default: holder.mImage.setImageResource(R.drawable.mac); break;
            }

            switch (products.get(position).getStore().getThumbnail()) {
                case 0: holder.mImageStore.setImageResource(R.drawable.bestbuy); break;
                case 1:
                    holder.mImageStore.setImageResource(R.drawable.sanjuan);
                    break;
                case 2:
                    holder.mImageStore.setImageResource(R.drawable.dell);
                    break;
                case  3: holder.mImageStore.setImageResource(R.drawable.homedepot); break;
                case  4: holder.mImageStore.setImageResource(R.drawable.vivero); break;
                case  5: holder.mImageStore.setImageResource(R.drawable.unlock); break;
                default:
                    holder.mImageStore.setImageResource(R.drawable.vivero);
                    break;
            }
            holder.mDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), products.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });

         /*   holder.mEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemProduct itemProduct = new ItemProduct();
                    Intent intento = new Intent(context,ActivityProduct.class);
                    intento.putExtra("ITEM", itemProduct);
                    ((ActivityMain) context).startActivityForResult(intento, products.get(position).getCode());
                }
            });
          */
        }

        public int getItemCount() {
            return products.size();
        }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mStore;
        public TextView mPhone;
        public TextView mAddress;
        public ImageView mImage;
        public ImageView mImageStore;
        public Button mDetail;
        public LinearLayout mEdit;
        private TextView mTitle;

        public ViewHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mAddress = v.findViewById(R.id.item_product_location);
            mImage = v.findViewById(R.id.item_product_image);
            mImageStore = v.findViewById(R.id.item_product_thumbnail);
            mDetail = v.findViewById(R.id.item_product_detail);
            mEdit = (LinearLayout) v.findViewById(R.id.card_home_info);
        }
    }


    }

