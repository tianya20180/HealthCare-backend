package wx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import wx.mapper.ArticleMapper;
import wx.poj.Article;
import wx.poj.Doctor;

import java.util.List;
import javax.annotation.Resource;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;


    public void insert(Article article){
        articleMapper.insert(article);

    }

    public Article getArticleById(Integer id){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return articleMapper.selectOne(queryWrapper);
    }
    public List<Article> getByDoctorId(Integer doctorId){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("doctor_id",doctorId);
        return articleMapper.selectList(queryWrapper);
    }

    public List<Article> getByCategory(Integer type){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("article_type",type);
        queryWrapper.orderByDesc("create_time");
        return articleMapper.selectList(queryWrapper);
    }

    public List<Article> getHotArticle(){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("view_count");
        return articleMapper.selectList(queryWrapper);
    }

    public List<Article>searchArticle(String title){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        queryWrapper.like("title",title);
        return articleMapper.selectList(queryWrapper);
    }

    public List<Article>getAllArticle(){
        QueryWrapper<Article>queryWrapper=new QueryWrapper<>();
        return articleMapper.selectList(queryWrapper);
    }

    public void changeViewCount(int count,int id){
        UpdateWrapper<Article>updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("view_count",count);
        articleMapper.update(null,updateWrapper);
    }

    public void changeLikeCount(int count,int id){
        UpdateWrapper<Article>updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id).set("like_count",count);
        articleMapper.update(null,updateWrapper);
    }



    public void deleteArticleById(Integer id){
        articleMapper.deleteById(id);
    }




}
