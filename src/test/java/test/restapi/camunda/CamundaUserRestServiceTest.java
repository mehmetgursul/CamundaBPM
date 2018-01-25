package test.restapi.camunda;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CamundaUserRestServiceTest extends ConfigureTest {

	@Test
	public void addUser() {
		JSONObject passwordObj = new JSONObject();
		passwordObj.put("password", "testPsw-");

		JSONObject profileObj = new JSONObject();
		profileObj.put("credentials", passwordObj);
		profileObj.put("email", "no-reply@test.CamundaTestUser");
		profileObj.put("lastName", "CamundaTestUserLastName");
		profileObj.put("firstName", "CamundaTestUserFirstName");
		profileObj.put("id", "CamundaTestUserID");

		JSONObject userObj = new JSONObject();
		userObj.put("profile", profileObj);

		given().contentType("application/json").body(userObj.toString()).when().post("engine-rest/user/create").then()
				.statusCode(204);
	}

	@Test
	public void getUserByFirstName() {
		given().when().get("/engine-rest/user?firstName=CamundaTestUserFirstName").then().statusCode(200);
	}

	@Test
	public void shouldResponseZeroNumberOfMatchingUserForInvalidUserFirstName() {
		given().when().get("/engine-rest/user/count?firstName=" + RandomStringUtils.random(32)).then().body("count",
				equalTo(0));
	}

	@Test
	public void removeUser() {
		given().contentType("application/json").when().delete("engine-rest/user/CamundaTestUserID").then()
				.statusCode(204);
	}
}
