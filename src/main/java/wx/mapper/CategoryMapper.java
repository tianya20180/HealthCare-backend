package wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wx.poj.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}