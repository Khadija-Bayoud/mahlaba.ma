package euromed.ia.freshharvest.Activity;

import java.util.ArrayList;

import euromed.ia.freshharvest.Domain.CartDomain;
public class AppDataWish {

    private static AppDataWish instance;
    private ArrayList<CartDomain> existingProducts;

    private AppDataWish() {
        existingProducts = new ArrayList<>();
    }

    public static AppDataWish getInstance() {
        if (instance == null) {
            instance = new AppDataWish();
        }
        return instance;
    }

    public ArrayList<CartDomain> getExistingProducts() {
        return existingProducts;
    }

    public void addExistingProduct(CartDomain product) {
        existingProducts.add(product);
    }
}
