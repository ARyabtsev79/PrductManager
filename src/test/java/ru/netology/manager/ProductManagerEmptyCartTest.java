package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerEmptyCartTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "Черный полдень", 650, "П. Корнев");
    Book item2 = new Book(2, "Анклавы", 800, "В. Панов");
    Book item3 = new Book(3, "Приграничье", 1200, "П. Корнев");
    Book item4 = new Book(4, "Dobrý voják Švejk. Zajímavé příhody poctivého vojína", 710, "Jaroslav Hašek");
    Smartphone item5 = new Smartphone(5, "OUKITEL WP6 6/128GB, Black", 22600, "OUKITEL");
    Smartphone item6 = new Smartphone(6, "RedMe 5A Dual, Black", 29750, "Xiaomi");
    Smartphone item7 = new Smartphone(7, "Vsmart Joy 4 4/64GB, Black Onyx", 5600, "Vsmart");
    Smartphone item8 = new Smartphone(8, "Xiaomi Redmi 9 4/64GB (NFC), Grey", 10300, "Xiaomi");

    @Test
    public void searchByBookNameNoProduct() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Приграничье");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookAuthorNoProducts() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Jaroslav Hašek");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphoneManufacturerNoProducts() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("OUKITEL");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNameNoProduct() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Xiaomi Redmi 9 4/64GB (NFC), Grey");
        assertArrayEquals(expected, actual);
    }
}
