package instructionReorder;


/**
 * @auther: LvSheng
 * @date: 2025/10/8
 * @description:
 */
public class InstructionReorderingDemoEnhanced {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        int reorderCount = 0;

        // 运行更多次来统计重排序发生的概率
        while (count < 1000000) {
            count++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(() -> {
                // 添加一些无操作的空循环，增加重排序的机会
                for (int i = 0; i < 10; i++) {
                    // 空循环
                }
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                // 添加一些无操作的空循环，增加重排序的机会
                for (int i = 0; i < 10; i++) {
                    // 空循环
                }
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (x == 0 && y == 0) {
                reorderCount++;
                System.out.println("第 " + count + " 次检测到指令重排序! 总计: " + reorderCount + " 次");
            }
        }

        System.out.println("总计运行: " + count + " 次");
        System.out.println("检测到重排序: " + reorderCount + " 次");
        System.out.println("重排序概率: " + (reorderCount * 100.0 / count) + "%");
    }
}
