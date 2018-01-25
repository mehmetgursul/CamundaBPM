package test.restapi.camunda;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class ConfigureTest {

	@BeforeClass
	public static void setup() {

		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8080);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;
	}

}
