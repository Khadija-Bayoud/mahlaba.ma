package euromed.ia.freshharvest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import euromed.ia.freshharvest.Adapter.BestDealAdapter;
import euromed.ia.freshharvest.Adapter.CategoryAdapter;
import euromed.ia.freshharvest.Domain.CategoryDomain;
import euromed.ia.freshharvest.Domain.ItemsDomain;
import euromed.ia.freshharvest.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;

    ImageView cart, fav, profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        cart = findViewById(R.id.cart);
        fav = findViewById(R.id.fav);
        profile = findViewById(R.id.profile);
        cart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CartActivity.class);
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

        initrecyclerViewCat();
//        initLocation();
        initRecyclerViewBestDeal();
    }

//    private void initLocation() {
//        String[] items = new String[]{"Sbaa Rouadi", "Bensouda"};
//        final Spinner locationSpinner = findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        locationSpinner.setAdapter(adapter);
//    }

    private void initrecyclerViewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1", "Vegetable"));
        items.add(new CategoryDomain("cat2", "Fruits"));
        items.add(new CategoryDomain("cat3", "Dairy"));
        items.add(new CategoryDomain("cat4", "Drinks"));
        items.add(new CategoryDomain("cat5", "Grain"));

        recyclerViewCat = findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);
    }

    private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal = findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        bestDealAdapter = new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }

    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("msemen","Msemen Beldi",3.5,"Msemen Beldi: Flaky, savory Moroccan pancakes with a delightful blend of spices.",4.2));
        items.add(new ItemsDomain("omelette", "Omelette nature", 8, "Omelette Nature: A classic and simple French omelette, perfect for a quick and delicious breakfast or brunch.", 4.2));
        items.add(new ItemsDomain("harcha", "Harcha", 4, "Harcha: Moroccan semolina pancakes, crispy on the outside and soft on the inside, a delightful North African treat.", 4.2));
        items.add(new ItemsDomain("bghirir", "Beghrir", 8, "Beghrir: Moroccan honeycomb pancakes, a unique and spongy delight drizzled with honey and butter.", 4.2));
        items.add(new ItemsDomain("briwat", "Salted Briwat", 15, "Salted Briwat: Moroccan pastry triangles filled with a savory blend of ingredients, offering a delightful fusion of flavors.", 4.2));
        items.add(new ItemsDomain("kroissa", "Croissants", 4.5, "Croissants: Buttery and flaky French pastries, a quintessential breakfast treat loved worldwide.", 4.2));

        return items;
    }
}