//package store.web.configuration;
//
//import javax.servlet.ServletContext;
//
//import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
//import org.ocpsoft.rewrite.config.Configuration;
//import org.ocpsoft.rewrite.config.ConfigurationBuilder;
//import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
//import org.ocpsoft.rewrite.servlet.config.rule.Join;
//
//@RewriteConfiguration
//public class Html5ModeConf extends HttpConfigurationProvider {
//  @Override
//  public Configuration getConfiguration(ServletContext servletContext) {
//    return ConfigurationBuilder.begin()
//        .addRule(Join.path("/registration").to("/home.html"))
//  }
//
//  @Override
//  public int priority() {
//    return 10;
//  }
//}
