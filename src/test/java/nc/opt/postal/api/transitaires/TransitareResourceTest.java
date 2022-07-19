package nc.opt.postal.api.transitaires;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TransitareResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .when()
            .get("/transitaires")
            .then()
            .statusCode(200)
            .contentType(MediaType.APPLICATION_JSON)
            .body("$.size()", is(24))
            .body("[0].name", is("EKVF"))
            .body("[0].phone", is("27.25.92"));
    }
}
