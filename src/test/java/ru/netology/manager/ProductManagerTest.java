package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "Черный полдень", 650, "П. Корнев");
    Book item2 = new Book(2, "Анклавы", 800, "В. Панов");
    Book item3 = new Book(3, "Nineteen Eighty-Four", 1200, "George Orwell");
    Book item4 = new Book(4, "Dobrý voják Švejk. Zajímavé příhody poctivého vojína", 710, "Jaroslav Hašek");
    Smartphone item5 = new Smartphone(5, "OUKITEL WP6 6/128GB, Dlack", 22600, "OUKITEL");
    Smartphone item6 = new Smartphone(6, "Google Pixel 4a, Red", 29750, "Google");
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
    void searchByBookName() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Dobrý voják Švejk. Zajímavé příhody poctivého vojína");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("В. Панов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Толстой");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item8};
        Product[] actual = manager.searchBy("Xiaomi Redmi 9 4/64GB (NFC), Grey");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("OUKITEL");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

}