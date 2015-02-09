package simple.web.blog.web;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Template;

import osgi.web.common.Controller;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.headers.RequireCapability;

@Component
@Path("/")
@Requieres.AngularJS @Requieres.Bootstrap
public class BlogApp implements Controller {

	@GET
    @Template(name="index.hbs")
	@Produces( MediaType.TEXT_HTML )
    public Map<String, String> get() { 
		Map<String, String> model = new HashMap<>();
		model.put("site_title", "Simple OSGi Blog");
		return model; 
	}
	
}

@interface Requieres {

    @RequireCapability(ns = "bootstrap.css", filter = "${frange;3.2.0}")
    @interface Bootstrap {}
    
    @RequireCapability(ns = "angular.js", 	 filter = "${frange;1.2.21}")
    @interface AngularJS {}
    
}