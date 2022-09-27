package main;

import business.BusinessImpl;
import business.IBusiness;
import dao.DaoImplVersionOne;
import dao.IDao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        /*
         * Injection Dependency statically instantiation
         * */
        DaoImplVersionOne daoImplVersionOne = new DaoImplVersionOne();
        BusinessImpl business = new BusinessImpl();

        /*
         * Injection Dependency dynamic instantiation
         * */

        Class className = Class.forName("dao.DaoImplVersionOne");
        Class businessClassName = Class.forName("business.BusinessImpl");
        IDao idao = (IDao) className.newInstance();
        IBusiness iBusiness = (IBusiness) businessClassName.newInstance();

        /*
         * Invoke Method Dynamically
         * */

        Method method = businessClassName.getMethod("setDao" , IDao.class);
        method.invoke(iBusiness , idao);

        System.out.println(iBusiness.calculate());
    }
}
