package test.restapi.camunda;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CamundaTaskRestServiceTest extends ConfigureTest {

	static String taskID;

	@BeforeClass
	public static void setUp() {
		taskID = RandomStringUtils.randomAlphabetic(32);
	}

	@Test
	public void canCreateTask() {
		JSONObject taskObj = new JSONObject();

		taskObj.put("id", taskID);
		taskObj.put("name", "Camunda Test Task");
		taskObj.put("description", "Camunda Test Task should be done immediately!");
		taskObj.put("priority", 10);

		given().contentType("application/json").body(taskObj.toString()).when().post("/engine-rest/task/create").then()
				.statusCode(204);
	}

	@Test
	public void getTaskByID() {
		given().when().get("/engine-rest/task/" + taskID).then().body("name", equalTo("Camunda Test Task"));
	}
	
	@Test
	public void runCompleteTask() {
		given().contentType("application/json").body("").when().post("/engine-rest/task/" + taskID + "/complete").then()
				.statusCode(204);
	}

	@Test
	public void shouldResponseNotFoundForRequestingInvalidTaskId() {
		given().when().get("/engine-rest/task/" + RandomStringUtils.random(32)).then().statusCode(404);
	}
}