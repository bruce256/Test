package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import lombok.Data;

/**
 * @auther 儒尊
 * @date 2018/5/2
 **/
@Data
public class ProviderDemo {
	
	@Inject
	TitleModel titleModel;
	
	public static void main(String[] args) {
		ProviderDemo instance = Guice.createInjector(new Module() {
			
			@Override
			public void configure(Binder binder) {
				binder.bind(TitleModel.class).toProvider(TitleModelProvider.class);
			}
		}).getInstance(ProviderDemo.class);
		
		System.out.println(instance.titleModel.getTitle());
	}
}
