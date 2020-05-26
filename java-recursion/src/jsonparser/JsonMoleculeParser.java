package jsonparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonMoleculeParser {

	public Map<String, Object> parseJsonObject(JsonObject jsonObject) {
		// no need of sequencing hence not using linkedhashmap
		// no need soritng hence not using treemap
		// garbage collection not needed on removal hence not using weakhashmap
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			if (value.isJsonPrimitive()) {
				jsonMap.put(key, getPrimitveValue(value.getAsJsonPrimitive()));
			} else if (value.isJsonObject()) {
				jsonMap.put(key, parseJsonObject(value.getAsJsonObject()));
			} else if (value.isJsonArray()) {
				List<Object> arrayObjects = new ArrayList<>();
				Iterator<JsonElement> jsonItertor = value.getAsJsonArray().iterator();

				while (jsonItertor.hasNext()) {
					parseArrayObject(jsonItertor.next(), arrayObjects);
				}
				jsonMap.put(key, arrayObjects);
			}
		}

		return jsonMap;

	}

	private void parseArrayObject(JsonElement element, List<Object> arrayObjects) {
		if (element.isJsonPrimitive()) {
			arrayObjects.add(getPrimitveValue(element.getAsJsonPrimitive()));
		} else if (element.isJsonObject()) {
			JsonObject jsonObj = element.getAsJsonObject();
			arrayObjects.add(parseJsonObject(jsonObj));
		} else if (element.isJsonArray()) {
			List<Object> innerArray = new ArrayList<Object>();
			Iterator<JsonElement> iterator = element.getAsJsonArray().iterator();
			while (iterator.hasNext()) {
				JsonElement innerElement = iterator.next();
				parseArrayObject(innerElement, innerArray);
			}
		}

	}

	private Object getPrimitveValue(JsonPrimitive primitiveValue) {
		if (primitiveValue.isBoolean()) {
			return primitiveValue.getAsBoolean();
		} else if (primitiveValue.isNumber()) {
			return primitiveValue.getAsInt();
		} else {
			return primitiveValue.getAsString();
		}
	}
}
