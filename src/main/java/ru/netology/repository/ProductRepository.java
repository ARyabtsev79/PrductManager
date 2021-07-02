package ru.netology.repository;

import ru.netology.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product product) {
        int resultLength = items.length + 1;
        Product[] tmp = new Product[resultLength];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        items = tmp;
    }
}
