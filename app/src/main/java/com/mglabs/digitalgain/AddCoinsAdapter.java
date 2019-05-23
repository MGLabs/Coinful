package com.mglabs.digitalgain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mglabs.digitalgain.model.Coin;

import java.util.List;

public class AddCoinsAdapter extends RecyclerView.Adapter<AddCoinsAdapter.AddCoinsHolder> {

    private final CoinStore store;
    private final Context mContext;
    private LayoutInflater mInflater;
    private List<Coin> coinList;

    //Constructor
    public AddCoinsAdapter(Context context, CoinStore store) {
        mInflater = LayoutInflater.from(context);
        this.store = store;
        this.mContext = context;
    }

    @NonNull
    @Override
    public AddCoinsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.add_coins_list_item, parent, false);
        return new AddCoinsHolder(view);
    }

    // Called each time I want to update and display(refresh) a list item
    @Override
    public void onBindViewHolder(@NonNull AddCoinsHolder holder, int position) {
        if (CoinStore.getCoinList() != null) {
            Coin current = CoinStore.getCoinList().get(position);
            holder.coinName.setText(current.getName());
        } else {
            holder.coinName.setText("No coin found");
        }

        //TODO onClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add the coin to favs
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
    public class AddCoinsHolder extends RecyclerView.ViewHolder {

        TextView coinName;

        public AddCoinsHolder(@NonNull View itemView) {
            super(itemView);

            coinName = itemView.findViewById(R.id.add_coin_name_tv);
        }
    }
}

