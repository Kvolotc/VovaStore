//package store.web.securityConfiguration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//
//	@Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//                .antMatchers(HttpMethod.GET).permitAll()
//                .antMatchers("/getCurrentUser").permitAll()
//                .antMatchers("/allMountainBikes/**").permitAll()
//                .antMatchers("/getCountPage/mountainBikes").permitAll()
//                .antMatchers("/getCountPage/allMountainBikes").permitAll()
//                .antMatchers("/getCountPage/racingBikes").permitAll()
//                .antMatchers("/countSearchBikes/").permitAll()
//                .antMatchers("/maxPriceBikes").permitAll()
//                .antMatchers("/bikes").permitAll()
//                .antMatchers("/racingBikes/**").permitAll()
//                .antMatchers("/searchBikes/").permitAll()
//                .antMatchers("/getCountPage/brakes").permitAll()
//                .antMatchers("/countSearchBrakes/").permitAll()
//                .antMatchers("/maxPriceBrakes").permitAll()
//                .antMatchers("/brakes/**").permitAll()
//                .antMatchers("/searchBrakes/").permitAll()
//                .antMatchers(HttpMethod.POST).permitAll()
//                .antMatchers("/newUser").authenticated()
//                .antMatchers("/email").authenticated()
//                .antMatchers("/photo").authenticated()
//                .antMatchers(HttpMethod.PUT).permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/logoutUser").permitAll();
//                
//    }
//}
