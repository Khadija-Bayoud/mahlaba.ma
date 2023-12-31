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

import euromed.ia.freshharvest.Adapter.CartAdapter;
import euromed.ia.freshharvest.Domain.CartDomain;
import euromed.ia.freshharvest.R;
import euromed.ia.freshharvest.Activity.AppData;

public class CartActivity extends AppCompatActivity {

    ImageView back;

    private RecyclerView recyclerViewCart;
    private CartAdapter adapter;
    private ArrayList<CartDomain> productList;
    private CartDomain product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
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
            }
        }

        adapter = new CartAdapter(productList);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(adapter);
    }

}