package annotate;

/**
 * @author lvsheng
 * @date 2018/9/2
 **/

@DiamondData(groupId = "groupId-ruzun", dataId = "dataId-ruzun")
public class DiamondProcessor {
	
	public void myTest() {
		DiamondData diamondData = this.getClass().getAnnotation(DiamondData.class);
		System.out.println(diamondData.groupId());
		System.out.println(diamondData.dataId());
	}
	
	public static void main(String[] args) {
		DiamondProcessor diamondProcessor = new DiamondProcessor();
		diamondProcessor.myTest();
	}
}
