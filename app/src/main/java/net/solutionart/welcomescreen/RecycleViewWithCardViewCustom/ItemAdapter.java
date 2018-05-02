package net.solutionart.welcomescreen.RecycleViewWithCardViewCustom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.solutionart.welcomescreen.R;

import java.util.List;

/**
 * Created by Ahanaf on 2/5/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private Context mCtx;
    private List<Item> itemList;

    public ItemAdapter(Context mCtx, List<Item> itemList) {
        this.mCtx = mCtx;
        this.itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.list_item, null);
            ItemViewHolder holder = new ItemViewHolder(view);
            return holder;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        try {
            final Item item = itemList.get(position);
            holder.textView_Name.setText(item.getName());
            holder.textView_ID.setText(String.valueOf(item.getId()));
        }
        catch (Exception ex){
            Log.d("Adapter" , ex.getMessage());
        }
        //image can be load with GLIDE library . Glide needs to be import from gradle
        //Glide.with(mCtx).load(product.getProduct_image()).into(holder.imageView);

        //if there is a click listerner in cardView
        /*try {
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(v.getContext(), ProductActivity.class);
                        intent.putExtra("product_id", String.valueOf(product.getId()));
                        v.getContext().startActivity(intent);
                        Log.d("ProductAdapter1 ", String.valueOf(product.getId()));
                    }
                    catch (Exception ex)
                    {
                    }
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView_Name;
        TextView textView_ID;
        CardView cardview_layoutitem;

        public ItemViewHolder(View itemView) {
            super(itemView);
            try {
                imageView = itemView.findViewById(R.id.imageViewItem);
                textView_Name = itemView.findViewById(R.id.textViewName);
                textView_ID = itemView.findViewById(R.id.textViewID);
                cardview_layoutitem = (CardView) itemView.findViewById(R.id.cardview_layout_item);
            }
            catch (Exception ex){

            }
        }
    }
}
