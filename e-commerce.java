import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductExtractor {

    public static void main(String[] args) {
        String url = "(link unavailable)";
        List<Product> products = extractProducts(url);
        writeProductsToCSV(products, "products.csv");

        System.out.println("Product Information:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Rating: " + product.getRating());
            System.out.println("------------------------");
        }
    }

    private static List<Product> extractProducts(String url) {
        List<Product> products = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements productElements = document.getElementsByClass("s-result-item");

            for (Element productElement : productElements) {
                String name = productElement.getElementsByClass("a-size-medium a-color-base a-text-normal").text();
                String price = productElement.getElementsByClass("a-price-whole").text();
                String rating = productElement.getElementsByClass("a-icon-alt").text();

                Product product = new Product(name, price, rating);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("Error extracting products: " + e.getMessage());
        }
        return products;
    }

    private static void writeProductsToCSV(List<Product> products, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Name,Price,Rating");
            for (Product product : products) {
                writer.println(product.getName() + "," + product.getPrice() + "," + product.getRating());
            }
            System.out.println("Products written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing products to CSV: " + e.getMessage());
        }
    }

    private static class Product {
        private String name;
        private String price;
        private String rating;

        public Product(String name, String price, String rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getRating() {
            return rating;
        }
    }
}