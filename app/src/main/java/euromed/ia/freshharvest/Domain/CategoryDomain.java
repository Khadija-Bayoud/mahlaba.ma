package euromed.ia.freshharvest.Domain;

public class CategoryDomain {
    private String imgPath;
    private String title;

    public CategoryDomain(String imgPath, String title) {
        this.imgPath = imgPath;
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
