import java.util.List;

/**
 * @ClassName: Menu
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/12/29 10:23
 * @Version 1.0
 */
public class Menu {
    // 菜单id
    private String id;
    // 菜单名称
    private String name;
    // 父菜单id
    private String parentId;
    // 子菜单
    private List<Menu> children;

    public Menu(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
