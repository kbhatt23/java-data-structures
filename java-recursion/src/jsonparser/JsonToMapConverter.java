package jsonparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonToMapConverter {
public static void main(String[] args) throws Exception {
	String JSON_PATH = "sample.json";
	BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
	JsonParser parser = new JsonParser();
	JsonObject jsonObject = parser.parse(br).getAsJsonObject();
	JsonMoleculeParser JsonMoleculeParser= new JsonMoleculeParser();
	Map<String, Object> parseJsonObject = JsonMoleculeParser.parseJsonObject(jsonObject);
	System.out.println("final map "+parseJsonObject);
}
}
