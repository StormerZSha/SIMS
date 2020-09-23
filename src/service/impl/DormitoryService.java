package service.impl;

import dao.impl.DormitoryDao;
import dao.intf.IDormitoryDao;
import domain.Dormitory;
import service.intf.IDormitoryService;

import java.util.List;

public class DormitoryService implements IDormitoryService {
    IDormitoryDao dormitoryDao = new DormitoryDao();

    /**
     * 根据dno查询宿舍信息
     * @param dno
     * @return
     * @throws Exception
     */
    @Override
    public Dormitory findByDno(int dno) throws Exception {
        Dormitory result = dormitoryDao.findByDno(dno);
        return result;
    }

    @Override
    public List<Dormitory> findAll() throws Exception {
        List<Dormitory> result = dormitoryDao.findAll();
        return result;
    }

    @Override
    public void addDormitory(Dormitory dormitory) throws Exception {
        dormitoryDao.inset(dormitory);
    }

    @Override
    public void deleteById(int id) throws Exception {
        dormitoryDao.deleteById(id);
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<Dormitory> findLike(String keyword) throws Exception {
        List<Dormitory> result = dormitoryDao.findLike("%" + keyword + "%");
        return result;
    }

    /**
     * 查询宿舍详情信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Dormitory findDetail(int id) throws Exception {
        Dormitory result = dormitoryDao.findDetail(id);
        return result;
    }
}
