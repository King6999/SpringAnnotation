package jx.dao;

import org.springframework.stereotype.Repository;

@Repository//默认id是类名第一个字母小写
public class BookDao {

    private int flag = 1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "flag=" + flag +
                '}';
    }
}
