package msg.curie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;

//@Configuration
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class HALConfiguration {

	@Bean
	public CurieProvider curieProvider() {
		
		return new DefaultCurieProvider("msg", new UriTemplate("http://msg.com/application#{rel}"));
		
	}
	
	
	
}
