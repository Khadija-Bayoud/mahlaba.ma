package euromed.ia.freshharvest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import euromed.ia.freshharvest.Adapter.CartAdapter;
import euromed.ia.freshharvest.Domain.CartDomain;
import euromed.ia.freshharvest.R;
import euromed.ia.freshharvest.Activity.AppData;

public class CartActivity extends AppCompatActivity {

    ImageView back, home, fav, profile;

    private RecyclerView recyclerViewCart;
    private CartAdapter adapter;
    private ArrayList<CartDomain> productList;
    private CartDomain product;
    float total_price = 0.0F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        fav = findViewById(R.id.fav);
        profile = findViewById(R.id.profile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        home.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });
        fav.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), WishListActivity.class);
            startActivity(intent);
            finish();
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        });
        initCart();
    }

    private void initCart() {

        Intent intent = getIntent();
        AppData appData = AppData.getInstance();
        ArrayList<CartDomain> existingProducts = appData.getExistingProducts();

        productList = new ArrayList<>();
        recyclerViewCart = findViewById(R.id.cartRecycler);

        if (existingProducts.isEmpty()) {
            product = (CartDomain) intent.getSerializableExtra("cartDomain");
            productList.add(product);
        }else{
            for (int i = 0; i < existingProducts.size(); i++) {
                product = existingProducts.get(i);
                productList.add(product);
                total_price = total_price + Float.parseFloat(product.getPrice().split(" ")[0]);
                Log.i("Product", String.valueOf(total_price));
            }
        }

        adapter = new CartAdapter(productList);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(adapter);
        TextView total = findViewById(R.id.totalPrice);
        total.setText(total_price + " MAD");
    }

}