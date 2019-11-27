/*
package xmlbeans;

import com.alibaba.fastjson.JSON;
import org.apache.xmlbeans.XmlException;
import org.openuri.easypo.PurchaseOrderDocument;

import java.io.File;
import java.io.IOException;

*/
/**
 * @auther 儒尊
 * @date 2018/4/23
 **//*

public class PurchaseOrderDocumentTest {
	
	public static void main(String[] args) {
		try {
			PurchaseOrderDocument               purchaseOrderDocument = PurchaseOrderDocument.Factory.parse(new File("/work/github/Test/src/main/resources/easy.xml"));
			PurchaseOrderDocument.PurchaseOrder purchaseOrder         = purchaseOrderDocument.getPurchaseOrder();
			System.out.println(purchaseOrder.getCustomer().getName());
			System.out.println(purchaseOrder.toString());
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
*/
