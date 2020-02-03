package cinema.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {
	
	@Bean
	public ModelMapper modelMapper() {
<<<<<<< HEAD
	    return new ModelMapper();
	}
	
}
=======
		return new ModelMapper();
	}

}
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
