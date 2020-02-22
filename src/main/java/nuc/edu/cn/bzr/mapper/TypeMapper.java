package nuc.edu.cn.bzr.mapper;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    //查询全部博客类型
    public List<Type> findAllType();
    //根据类型名字查询博客
    public Type findType(String typeNmae);
    public int insertType(Type type);
    public int deleteType(int typeId);
    public int updateType(Type type);
    public int getBlogNumByTypeId(int typeId);
    public List<Blog> findBlogByTypeId(Type type);
}
