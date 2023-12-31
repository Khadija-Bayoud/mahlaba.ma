package euromed.ia.freshharvest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import euromed.ia.freshharvest.Domain.CartDomain;
import euromed.ia.freshharvest.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {

    ArrayList<CartDomain> items;
    Context context;

    public CartAdapter(ArrayList<CartDomain> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new CartAdapter.viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position) {

        CartDomain item = items.get(position);

        holder.name.setText(item.getTitle());
        holder.price.setText(item.getPrice());
        holder.description.setText(item.getDescription());

        Glide.with(context)
                .load(item.getImgPath())
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView name, price, description;
        ImageView pic;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.Name);
            price = itemView.findViewById(R.id.Price);
            description = itemView.findViewById(R.id.Description);

            pic = itemView.findViewById(R.id.pic);
        }
    }
}
