class Product {
    private String idProduct;
    private String nameProduct;
    private Categories categories;

    public Product(Product product) {
        this(product.getIdProduct(), product.getNameProduct(), new Category(product.getCategory()));
        }

    public Product(String idProduct, String nameProduct, Category category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.category = category;
    }

    public Object clone() {
        Product product = null;
        try {
            product = (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            product = new Product(
                this.getIdProduct(), this.getNameProduct(), this.getCategory());
        }
        product.category =(Category) this.category.clone();
        return product;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

@Override
public String toString() {
    return "Product{" +
            "idProduct='" + idProduct + '\'' +
            ", nameProduct='" + nameProduct + '\'' +
            ", category=" + category + '\'' +
            '}';
}
}

class Categories {
    private String idCatt;
    private String nameCatt;
}

public Categories(Categories kategori) {
    this(kategori.getIdCatt(), kategori.getNameCatt());
}

public Categories(String idCatt, String nameCatt) {
    this.idCatt = idCatt;
    this.nameCatt = nameCatt;
}

public Object clone() {
    try {
        return (Categories) super.clone();
    } catch (CloneNotSupportedException e) {
        return new Categories(this.getIdCatt(), this.getNameCatt());
    }
}

public String getIdCatt() {
    return idCatt;
}

public void setIdCatt(String idCatt) {
    this.idCatt = idCatt;
}

public String getNameCatt() {
    return nameCatt;
}

public void getNameCatt(String nameCatt) {
    this.nameCatt = nameCatt;
}

@Override
public String toString() {
    return "Categories{" +
            "id='" + idCatt + '\'' +
            ", Name='" + nameCatt + '\'' +
            '}';
}
}

public class deepCopy {
    public static void main(String args[]) {
        deepCopy main = new deepCopy();
        main.product1();
    }

    public void product1() {
        Category categories = new Categories("c01", "Gadget");
        Product laptop = new Product("p01", "Handphone", category);
        Product Smartphone = (Product) laptop.clone();

        Smartphone.getCategories().setCattName("Gadget");
        Smartphone.setFirstName("Zaid");

        System.out.println(laptop);
        System.out.println(Smartphone);
    }
}
