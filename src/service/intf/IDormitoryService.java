package service.intf;

import domain.Dormitory;

import java.util.List;

public interface IDormitoryService {
    /**
     * 根据dno查询宿舍信息
     * @param dno
     * @return
     * @throws Exception
     */
    Dormitory findByDno(int dno) throws Exception;

    /**
     * 获取所有宿舍信息
     * @return
     * @throws Exception
     */
    List<Dormitory> findAll() throws Exception;

    /**
     * 添加宿舍信息
     * @param dormitory
     * @throws Exception
     */
    void addDormitory(Dormitory dormitory) throws Exception;

    /**
     * 根据宿舍ID删除宿舍信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Dormitory> findLike(String keyword) throws Exception;

    /**
     * 查询宿舍详情信息
     * @param id
     * @return
     * @throws Exception
     */
    Dormitory findDetail(int id) throws Exception;
}
