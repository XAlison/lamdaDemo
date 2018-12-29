import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName: Main1
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/12/29 10:28
 * @Version 1.0
 */
public class Main1 {


    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();
        List<Menu> menus = new ArrayList<Menu>() {{
            add(new Menu("1", "系统管理", "0"));
            add(new Menu("2", "员工管理", "1"));
            add(new Menu("3", "权限管理", "1"));
            add(new Menu("4", "组织机构", "0"));
            add(new Menu("5", "部门管理", "4"));
            add(new Menu("6", "员工列表", "2"));
//            for (int i = 7; i < 50000; i++) {
//                add(new Menu(String.valueOf(i), "员工列表" + i, String.valueOf(i)));
//            }
        }};
        List<Menu> targetMenus = new ArrayList<>();
        menus.parallelStream().forEachOrdered(menuOne -> {
                    Boolean flag = false;
                    for (Menu menuTwo : menus) {
                        if (menuOne.getParentId().equals(menuTwo.getId())) {
                            flag = true;
                            if (menuTwo.getChildren() == null) {
                                menuTwo.setChildren(new ArrayList<>());
                            }
                            if (!menuTwo.getChildren().contains(menuOne)) {
                                menuTwo.getChildren().add(menuOne);
                            }
                            break;
                        }
                    }
                    if (!flag) {
                        targetMenus.add(menuOne);
                    }

                }
        );

        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        System.out.println("执行时间:" + Float.toString(seconds) + " seconds.");
        System.err.print(targetMenus);


    }
}
