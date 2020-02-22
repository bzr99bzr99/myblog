package nuc.edu.cn.bzr.service.serviceimpl;

import nuc.edu.cn.bzr.mapper.TypeMapper;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Type;
import nuc.edu.cn.bzr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> findAllType() {
        return typeMapper.findAllType();
    }

    @Override
    public Type findType(String typeName) {
        return typeMapper.findType(typeName);
    }

    @Override
    public Type insertType(Type type) {
        if (typeMapper.insertType(type) == 0) {
            return null;
        }
        return type;
    }

    @Override
    public int deleteType(int typeId) {
        return typeMapper.deleteType(typeId);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int getBlogNumByTypeId(int typeId) {
        return typeMapper.getBlogNumByTypeId(typeId);
    }

    @Override
    public List<Blog> findBlogByTypeId(Type type) {
        return typeMapper.findBlogByTypeId(type);
    }
}
