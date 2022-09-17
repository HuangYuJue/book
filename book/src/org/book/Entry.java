package org.book;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Entry {
    public static void main(String[] args) {
        /* 由于Map中存放的元素均为键值对，故每一个键值对必然存在一个映射关系。  */
        Map<Integer, Users> map = new HashMap<>();
        Users users1 = new Users(1, "1", "1", "1", 1);
        Users users2 = new Users();
        map.put(1, users1);
        System.out.println("map1:" + map.get(1));
        users2.setId(2);
        users2.setUname("2");
        users2.setPwd("2");
        users2.setEmail("2");
        users2.setRole(2);
        map.put(2, users2);
        System.out.println("map2:" + map.get(2));
        users2.setId(3);
        users2.setUname("3");
        users2.setPwd("3");
        users2.setEmail("3");
        users2.setRole(3);
        map.put(3, users2);
        System.out.println("对象users2内的值" + users2.getId() + users2.getUname() + users2.getPwd() + users2.getEmail() + users2.getRole());
        //user2因为赋了两次值，所以前面那一次被覆盖，id为2的那一次的user被id为3的覆盖，所以user2为id为3的数据。
        System.out.println("map3:" + map.get(3));
        //map2与map3的key不同，但是user2的值第一次赋值被第二次覆盖，所以key为2和3的Users(Object)是一样的，user2为id=3的那一组

        /*
        ① Map中采用 Entry内部类来表示一个映射项，映射项包含Key和Value (我们总说键值对键值对, 每一个键值对也就是一个Entry)，
        Map.Entry里面包含getKey()和getValue()方法获取键和值;
        ② entrySet是 java中 键-值 对的集合，Set里面的类型是Map.Entry，一般可以通过map.entrySet()得到。
        entrySet实现了Set接口，里面存放的是键值对。一个K对应一个V。
         */
        Set<Map.Entry<Integer, Users>> entries = map.entrySet();
        System.out.println("entries为：" + entries);
        //entries为：[1=org.book.Users@1d44bcfa, 2=org.book.Users@266474c2, 3=org.book.Users@266474c2]
        for (Map.Entry<Integer, Users> entry : entries) {
            Integer key = entry.getKey();
            System.out.println("entry.getKey()的值为：" + key);
            //entry.getKey()的值为：Integer
            Users value = entry.getValue();
            System.out.println("entry.getValue()的值为：" + value);
            //entry.getValue()的值为：Object
            /* 可通过value获取到 Object 中的参数值 */
            String uname = value.getUname();
            System.out.println("name:" + uname);
        }
    }
}
class Users {
    private Integer id;
    private String uname;
    private String pwd;
    private String email;
    private Integer role;

    public Users() {
    }

    public Users(Integer id, String uname, String pwd, String email, Integer role) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
