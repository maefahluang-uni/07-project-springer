package order.service.orderservice;

public class ProductDTO {
    
    private long ID;

    private String Name ;

    private String Discription;

    private long Price;

    private long Stock;

    String category;

    private String Brand;

    //constructors 
    ProductDTO(){

    }
    //constructors 
    public ProductDTO(long ID, String Name, String Discription, long Price, long Stock, String Category, String Brand) {
        this.ID = ID;
        this.Name = Name;
        this.Discription = Discription;
        this.Price = Price;
        this.Stock = Stock;
        this.category = Category;
        this.Brand = Brand;
    }
    public long getId() {
        return ID;
    }
    public void setId(long ID) {
        this.ID = ID;
    }
    public String getNameProduct() {
        return Name;
    }
    public void setNameProduct(String Name) {
        this.Name = Name;
    }
    public String getDiscription() {
        return Discription;
    }
    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }
    public long getPrice() {
        return Price;
    }
    public void setPrice(long Price) {
        this.Price = Price;
    }
    public long getStock() {
        return Stock;
    }
    public void setStock(long Stock) {
        this.Stock = Stock;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
}
