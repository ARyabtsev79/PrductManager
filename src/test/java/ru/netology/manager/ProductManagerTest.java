package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
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


    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }


    @Test
    public void searchByBookName() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Dobrý voják Švejk. Zajímavé příhody poctivého vojína");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("В. Панов");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookNameNotValid() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Страж");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthorIfManyProducts() {
        Product[] actual = manager.searchBy("П. Корнев");
        Product[] expected = new Product[]{item1, item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item8};
        Product[] actual = manager.searchBy("Xiaomi Redmi 9 4/64GB (NFC), Grey");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("OUKITEL");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturerIfManyProducts() {
        Product[] expected = new Product[]{item6, item8};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNotValidManufacturerIfManyProducts() {
        Product[] actual = manager.searchBy("Sony");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByName() {
        Product[] actual = manager.searchBy("Кирпич");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByNameIfManyProducts() {
        Product[] actual = manager.searchBy("Кондиционер");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}