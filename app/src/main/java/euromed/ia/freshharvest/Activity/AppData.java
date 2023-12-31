package euromed.ia.freshharvest.Activity;

import java.util.ArrayList;

import euromed.ia.freshharvest.Domain.CartDomain;

public class AppData {

    private static AppData instance;
    private ArrayList<CartDomain> existingProducts;

    private AppData() {
        existingProducts = new ArrayList<>();
    }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
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
