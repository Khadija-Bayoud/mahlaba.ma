package euromed.ia.freshharvest.Activity;

import androidx.appcompat.app.AppCompatActivity;
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

    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        initrecyclerViewCat();
        initLocation();
        initRecyclerViewBestDeal();
    }

    private void initLocation() {
        String[] items = new String[]{"Sbaa Rouadi", "Bensouda"};
        final Spinner locationSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter);
    }

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
        items.add(new ItemsDomain("orange","Fresh Orange",6.2,"hdghagzdhhdg",4.2));
        items.add(new ItemsDomain("apple", "Fresh apple", 6.2, "dhfgdgfgj", 4.2));
        items.add(new ItemsDomain("watermelon", "Fresh watermelon", 6.2, "gdhghddf", 4.2));
        items.add(new ItemsDomain("berry", "Fresh berry", 6.2, "bdhgfdgfj", 4.2));
        items.add(new ItemsDomain("pineapple", "Fresh pineapple", 6.2, "bdhfjhddhb", 4.2));
        items.add(new ItemsDomain("strawberry", "Fresh strawberry", 6.2, "jhdfgdfgjs", 4.2));

        return items;
    }
}