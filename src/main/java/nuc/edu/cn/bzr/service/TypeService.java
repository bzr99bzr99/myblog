package nuc.edu.cn.bzr.service;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Type;

import java.util.List;

public interface TypeService {
    //查询全部博客类型
    public List<Type> findAllType();
    //根据博客类型名称查询
    public Type findType(String typeName);
    //增加一个Type
    public Type insertType(Type type);
    public int deleteType(int typeId);
    public int updateType(Type type);
    public int getBlogNumByTypeId(int typeId);
    public List<Blog> findBlogByTypeId(Type type);
}
