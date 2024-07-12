import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetBook() {
        // add the book to be fetched
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books")
                .then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDeleteBook() {
        // add book to the fetched data
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when()
                .post("/books")
                .then()
                .statusCode(200);
        // test deleting the book
        given()
                .contentType("application/json")
                .when()
                .delete("/books/878")
                .then()
                .statusCode(204);
        // get the book again
        given()
                .contentType("application/json")
                .when()
                .get("books/878")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage", equalTo("Book with isbn = 878 is not available"));
    }

    // test posting a book
    @Test
    public void testPostBook(){
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        // test adding a book
        given()
                .contentType("application/json")
                .body(book)
                .when()
                .post("/books")
                .then()
                .statusCode(200);
        // get the book
        given()
                .contentType("application/json")
                .when()
                .get("books/878")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("author",equalTo("Joe Smith"))
                .body("price",equalTo(18.95f));
        //cleanup
        given()
                .contentType("application/json")
                .when()
                .delete("/books/878");
    }

    // test updating a book
    @Test
    public void testUpdateBook(){
        // add the book to be updated
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books")
                .then()
                .statusCode(200);
        // update the book
        Book updatedBook = new Book("878", "Book 123", 20.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(updatedBook)
                .when()
                .put("/books/878")
                .then()
                .statusCode(200);
        // get the updated book
        given()
                .contentType("application/json")
                .when()
                .get("books/878")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("author",equalTo("Joe Smith"))
                .body("price",equalTo(20.95f));
        //cleanup
        given()
                .contentType("application/json")
                .when()
                .delete("/books/878");
    }

    // test getting books
    @Test
    public void testGetBooks(){
        // add the books to be fetched
        Book book1 = new Book("878", "Book 123", 18.95, "Joe Smith");
        Book book2 = new Book("879", "Book 124", 19.95, "Joe Smith");
        // add book one
        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books")
                .then()
                .statusCode(200);
        // add book one
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("/books")
                .then()
                .statusCode(200);
        // test getting the books
        given()
                .when()
                .get("books")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("books.isbn", hasItems("878","879"))
                .body("books.title", hasItems("Book 123","Book 124"))
                .body("books.price", hasItems(18.95f,19.95f))
                .body("books.author", hasItems("Joe Smith","Joe Smith"));
        //cleanup
        given()
                .contentType("application/json")
                .when()
                .delete("books/878");
        given()
                .contentType("application/json")
                .when()
                .delete("books/879");
    }


}
