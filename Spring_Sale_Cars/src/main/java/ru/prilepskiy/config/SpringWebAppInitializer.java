package ru.prilepskiy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//		appContext.register(ApplicationContextConfig.class);
//
//		// Dispatcher Servlet
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
//				new DispatcherServlet(appContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//
////		dispatcher.setInitParameter("contextClass", appContext.getClass().getName());
////        servletContext.addListener(new ContextLoaderListener(appContext));
//
//		// UTF8 Charactor Filter.
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.setInitParameter("forceEncoding", "true");
//		filter.addMappingForUrlPatterns(null, true, "/*");

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ApplicationContextConfig.class);
		ctx.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}