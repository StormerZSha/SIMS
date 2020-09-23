package service.impl;

import dao.impl.SpecialityDao;
import dao.intf.ISpecialityDao;
import domain.Speciality;
import service.intf.ISpecialitySercice;

import java.util.List;

public class SpecialityService implements ISpecialitySercice {
    ISpecialityDao specialityDao = new SpecialityDao();

    /**
     * 根据专业名称查询专业信息
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Speciality findSpecialityByName(String name) throws Exception {
        Speciality result = specialityDao.findByName(name);
        return result;
    }

    @Override
    public List<Speciality> findAll() throws Exception {
        List<Speciality> result = specialityDao.findAll();
        return result;
    }

    @Override
    public void addSpeciality(Speciality speciality) throws Exception {
        specialityDao.insert(speciality);
    }

    @Override
    public void deleteById(int id) throws Exception {
        specialityDao.deleteById(id);
    }

    @Override
    public List<Speciality> findLike(String keyword) throws Exception {
        List<Speciality> result = specialityDao.findLike("%" + keyword + "%");
        return result;
    }

    /**
     * 查询专业详情
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Speciality findDetail(int id) throws Exception {
        Speciality result = specialityDao.findDetail(id);
        return result;
    }
}
