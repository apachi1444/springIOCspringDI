package business;

import dao.IDao;

public class BusinessImpl implements IBusiness {

    private IDao dao = null;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        double a = dao.getData();
        return a * 5;

    }
}
