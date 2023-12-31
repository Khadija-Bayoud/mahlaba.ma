package euromed.ia.freshharvest.Domain;

import java.io.Serializable;

public class CartDomain implements Serializable {

    private int resourceID;
    private String name;
    private String price;
    private String description;

    public CartDomain(int resourceID, String name, String price, String description) {
        this.resourceID = resourceID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImgPath() {
        return resourceID;
    }

    public void setImgPath(int imgPath) {
        this.resourceID = resourceID;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
