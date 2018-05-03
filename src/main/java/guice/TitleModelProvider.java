package guice;


import com.google.inject.Provider;

/**
 * @auther 儒尊
 * @date 2018/5/2
 **/
public class TitleModelProvider implements Provider<TitleModel> {
	
	@Override
	public TitleModel get() {
		TitleModel titleModel = new TitleModel();
		titleModel.setTitle("ruzun");
		return titleModel;
	}
}
