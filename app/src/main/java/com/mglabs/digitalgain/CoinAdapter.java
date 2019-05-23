package com.mglabs.digitalgain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mglabs.digitalgain.model.Coin;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinHolder> {

    private final CoinStore store;
    private final Context mContext;
    private LayoutInflater mInflater;
    private List<Coin> coinList;

    //Constructor
    public CoinAdapter(Context context, CoinStore store) {
        mInflater = LayoutInflater.from(context);
        this.store = store;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CoinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.coin_list_item, parent, false);
        return new CoinHolder(view);
    }

    // Called each time I want to update and display(refresh) a list item
    @Override
    public void onBindViewHolder(@NonNull CoinHolder holder, final int position) {

        final Coin current = CoinStore.getCoinList().get(position);

        if (CoinStore.getCoinList() != null) {
            holder.bindTo(current);
        } else {
            holder.coinName.setText("No coin found");
        }

        //TODO onClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "ROW CLICKED", Toast.LENGTH_SHORT).show();
                /*// Accordion
                // Get the current state of the item
                boolean expanded = current.isExpanded();
                // Change the state
                current.setExpanded(!expanded);
                // Notify the adapter
                notifyItemChanged(position);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        if (CoinStore.getCoinList() != null)
            return CoinStore.getCoinList().size();
        else
            return 0;
    }

    //CoinHolder
    public class CoinHolder extends RecyclerView.ViewHolder {

        TextView coinName;
        TextView coinPrice;
        LinearLayout subItem;


        public CoinHolder(@NonNull View itemView) {
            super(itemView);

            coinName = itemView.findViewById(R.id.coin_name_tv);
            coinPrice = itemView.findViewById(R.id.coin_price_tv);
            subItem = itemView.findViewById(R.id.sub_item);
        }

        private void bindTo(Coin coin) {
            coinName.setText(coin.getName());
            coinPrice.setText(coin.getPrice());

            // Get the state
            boolean expanded = coin.isExpanded();
            // Set the visibility based on state
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        }
    }
}
