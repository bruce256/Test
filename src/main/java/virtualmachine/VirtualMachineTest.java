package virtualmachine;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author LvSheng
 * @date 2021/10/30
 **/
public class VirtualMachineTest {
    public static void main(String[] args) {
        try {
            // 该api的功能是让外部进程可以 在目标JVM（运行被监控、被控制的程序的JVM） 中启动一个线程，该线程会加载运行Agent，然后线程会将本jvm的状态返回给外部进程
            VirtualMachine virtualMachine = VirtualMachine.attach("90348");
            virtualMachine.getSystemProperties().forEach((k, v) -> {
                System.out.println(k + ":" + v);
            });
            virtualMachine.detach();
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
