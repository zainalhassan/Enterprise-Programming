package client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import model.Film;

public class Tester {
	
	public static void main(String[] args) {
	
		ClientConfig config = new DefaultClientConfig();
	
		Client client = Client.create(config);

		WebResource service = client.resource(getBaseURI());
		
		// Create one Film
		
		int filmIDUpdate = 52;
		
		Film film = new Film(filmIDUpdate, "Main Hoon na", 2004, "Shah Rukh Khan as Ram", 180, "A movie to remember" );
		
		ClientResponse response = service.path("rest").path("films").path(Integer.toString(film.getFilmID())).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, film);
		
		// Return code should be 201 == created resource
		
		System.out.println("Film with ID " + filmIDUpdate + " has been updated, Code Status("+response.getStatus()+")");
		
		// Get the Films
		
		System.out.println("\nGet the Films: " + service.path("rest").path("films").accept(
				MediaType.TEXT_XML).get(String.class));
		
		// Get JSON for application
		
		System.out.println("\nGet the Films in Json Format: " + service.path("rest").path("films").accept(
				MediaType.APPLICATION_JSON).get(String.class));
		
		// Get XML for application
		
		System.out.println("\nGet the Films in XML Format: " + service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
		
		// Get the Film with id 11388
		
		System.out.println("\nGet the Film by ID in XML Format: " + service.path("rest").path("films/"+filmIDUpdate).accept(
				MediaType.APPLICATION_XML).get(String.class));
		
		// Get Film with following ID and delete it 
		
		int filmIDDelete = 47;
		
		service.path("rest").path("films/"+filmIDDelete).delete();
		
		// Get the all films, the ID Above Is Removed
		
		System.out.println("\nGet all the Films, note ("+filmIDDelete+" has been deleted): " + service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
			
		// Create a Film
		
		String title = "The Dark Knight Rises";
		
		Form form = new Form();
		
		form.add("FilmID", 0);
		
		form.add("filmName", title);
		
		form.add("filmYear", 2012);
		
		form.add("filmCredits", "Christian Bale as Bruce Wayne");
		
		form.add("filmDuration", 150);
		
		form.add("filmReview", "Amazing movie,movie of the year");
		
		response = service.path("rest").path("films").type(MediaType.APPLICATION_FORM_URLENCODED)
								   .post(ClientResponse.class, form);
		
		System.out.println("\nForm response: \n\n" + response.getEntity(String.class));
		
		// Get the all Films, Film above should be created
		
		System.out.println("\nGet all the Films, note ("+title+" has been inserted): " + service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
	
	}
	
	private static URI getBaseURI() {
		
		return UriBuilder.fromUri("http://localhost:8080/EnterpriseProgramming-restful").build();
		
	}
	
}
