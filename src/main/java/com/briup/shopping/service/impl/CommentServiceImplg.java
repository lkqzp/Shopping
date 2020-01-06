package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.CommentEXg;
import com.briup.shopping.mapper.ex.CommentEXgMapper;
import com.briup.shopping.service.ICommentServiceg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImplg implements ICommentServiceg {
    @Autowired
    private CommentEXgMapper commentEXgMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentEXg> findAll() throws RuntimeException {
        List<CommentEXg> list=commentEXgMapper.findAll();
        System.out.println("dd");
        return list;
    }

    @Override
    public void saveOrupdate(Comment comment) throws RuntimeException {
        comment.setDate(new Date());
        if(comment==null){
            throw new RuntimeException("参数为空");
        }
        else if(comment.getId()==null){

            commentMapper.insert(comment);
        }
        else {
            commentMapper.updateByPrimaryKey(comment);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        commentMapper.deleteByPrimaryKey(id);
    }
}
