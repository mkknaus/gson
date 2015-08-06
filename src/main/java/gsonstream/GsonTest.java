package gsonstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;

public class GsonTest {
	List<Person> people = null;

	public GsonTest() {
		people = new ArrayList<Person>();
	}

	public static void main(String[] args) {
		GsonTest gt = new GsonTest();

		gt.doGson();
	}

	void doGson() {
		try {
			InputStream is = GsonTest.class.getResourceAsStream("data.json");

			JsonReader jsonReader = new JsonReader(new InputStreamReader(is, "UTF-8"));

			jsonReader.beginObject();

			while (jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if (name.equals("people")) {
					readPeopleArray(jsonReader);
				}
			}
			
			jsonReader.endObject();
			
			for(Person p : people){
				System.out.println(p.toString());
			}
		}
		catch (NullPointerException e){
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readPeopleArray(JsonReader jsonReader) throws IOException {
		jsonReader.beginArray();
		while (jsonReader.hasNext()) {
			readPersonObject(jsonReader);
		}
		jsonReader.endArray();
	}

	private void readPersonObject(JsonReader jsonReader) throws IOException {
		String name = null;
		String sirname = null;
		Long social_no = null;
		Long creadit_card_no = null;
		
		jsonReader.beginObject();
		while(jsonReader.hasNext()){
			String key = jsonReader.nextName();
			
			if(key.equals("details")){
				
				jsonReader.beginObject();
				
				while(jsonReader.hasNext()){
					String detailKey = jsonReader.nextName();
									
					if(detailKey.equals("social_no")){
						social_no = jsonReader.nextLong();
					}
					else if(detailKey.equals("creadit_card_no")){
						creadit_card_no = jsonReader.nextLong();
					}
					else{
						jsonReader.skipValue();
					}
				}
				
				jsonReader.endObject();
			}
			else if(key.equals("name")){
				name = jsonReader.nextString();
			}
			else if(key.equals("sirname")){
				sirname = jsonReader.nextString();
			}
		}
		jsonReader.endObject();
		
		people.add(new Person(name, sirname, social_no, creadit_card_no));
	}
}
