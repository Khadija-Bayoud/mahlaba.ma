package euromed.ia.freshharvest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import euromed.ia.freshharvest.R;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button logOut;

    ImageView home, cart, fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logOut = findViewById(R.id.logout);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        home = findViewById(R.id.home);
        cart = findViewById(R.id.cart);
        fav = findViewById(R.id.fav);
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
        fav.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), WishListActivity.class);
            startActivity(intent);
            finish();
        });

    }
}