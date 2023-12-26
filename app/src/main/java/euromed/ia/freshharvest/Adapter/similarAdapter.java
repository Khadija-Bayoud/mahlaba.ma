package euromed.ia.freshharvest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import euromed.ia.freshharvest.Domain.ItemsDomain;
import euromed.ia.freshharvest.R;

public class similarAdapter extends RecyclerView.Adapter<similarAdapter.viewholder> {
    ArrayList<ItemsDomain> items;
    Context context;

    public similarAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public similarAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_similar, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull similarAdapter.viewholder holder, int position) {

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getImgPath(), "drawable", holder.itemView.getContext().getOpPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.img);
        }
    }
}
