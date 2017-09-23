package com.example.greendaotest;

import com.example.greendaotest.greendao.DaoMaster;
import com.example.greendaotest.greendao.DaoSession;
import com.example.greendaotest.greendao.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/23.
 */

public class DataBaseManager {
    private static DataBaseManager sDatabaseManager;
    private UserDao mUserDao;

    public static DataBaseManager getInstance() {

        if (sDatabaseManager == null) {
            synchronized (DataBaseManager.class) {
                if (sDatabaseManager == null) {
                    sDatabaseManager = new DataBaseManager();
                    sDatabaseManager.init();
                }
            }
        }
        return sDatabaseManager;
    }

    private void init() {
        //先拿到daosession
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.mContext, "test-db"); //第二个参数是数据库名
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mUserDao = daoSession.getUserDao();
    }

    /**
     * 插入一个联系人
     *
     * @param user
     */
    public void insertUser(User user) {
        mUserDao.insert(user);
    }

    /**
     * 删除联系人
     *
     */
    public void deleteUser(String name) {
//        for (User user : users) {
//            mUserDao.delete(user); //删除对象
//        }

//        mUserDao.deleteByKey();
    }

    /**
     * 修改名字
     *
     * @param user
     */
    public void updateUser(User user, String changeName) {
        user.setUsername(changeName);
        mUserDao.update(user);
    }

    /**
     * 查询所有联系人
     */
    public List<String> queryAllUser() {
        List<String> names = new ArrayList<>();
        List<User> list = mUserDao.queryBuilder().list();
        for (User user : list) {
            String name = user.getUsername();
            String age = user.getAge();
            names.add(name + ".." + age);
        }
        return names;
    }

    /**
     * 根据筛选条件查询一条记录
     *
     * @param name
     * @return
     */
    public List<String> queryOne(String name) {
        List<String> result = new ArrayList<>();
        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.Username.like("%" + name + "%")).list();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            result.add(user.getAge());
        }
        return result;
    }


}
