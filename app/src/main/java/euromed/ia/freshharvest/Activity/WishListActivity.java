package euromed.ia.freshharvest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import euromed.ia.freshharvest.Adapter.WishListAdapter;
import euromed.ia.freshharvest.Domain.CartDomain;
import euromed.ia.freshharvest.R;
import euromed.ia.freshharvest.Activity.AppData;
import euromed.ia.freshharvest.Activity.AppDataWish;
public class WishListActivity extends AppCompatActivity {

    ImageView back;

    private RecyclerView recyclerViewWish;
    private WishListAdapter adapter;
    private ArrayList<CartDomain> productList;
    private CartDomain product;

    ImageView home, cart, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        home = findViewById(R.id.home);
        cart = findViewById(R.id.cart);
        profile = findViewById(R.id.profile);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });
        cart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CartActivity.class);
            startActivity(intent);
            finish();
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        });

        initWishList();
    }

    private void initWishList() {

        Intent intent = getIntent();
        AppDataWish appData = AppDataWish.getInstance();
        ArrayList<CartDomain> existingProducts = appData.getExistingProducts();

        productList = new ArrayList<>();
        recyclerViewWish = findViewById(R.id.wishRecycler);

        if (existingProducts.isEmpty()) {
            product = (CartDomain) intent.getSerializableExtra("cartDomain");
            productList.add(product);
        }else{
            for (int i = 0; i < existingProducts.size(); i++) {
                product = existingProducts.get(i);
                productList.add(product);
            }
        }

        adapter = new WishListAdapter(productList);
        recyclerViewWish.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewWish.setAdapter(adapter);
    }

}