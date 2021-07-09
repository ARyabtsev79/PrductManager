package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
public class ProductManager {
    private final ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            if (product.getName().contains(search)) {
                return true;
            }
            return product.getAuthor().contains(search);
        }
        if (product instanceof Smartphone) {
            if (product.getName().contains(search)) {
                return true;
            }
            return ((Smartphone) product).getManufacturer().contains(search);
        }
        return false;
    }

    public Product[] searchBy() {
        return new Product[0];
    }
}