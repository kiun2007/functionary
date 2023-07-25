package com.kiun.functionary.service.ruoyi;

import com.kiun.functionary.dao.sys.SysDictItemMapper;
import com.kiun.functionary.dao.sys.entity.SysDictItem;
import com.kiun.functionary.dao.sys.entity.SysDictItemExample;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 *
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Resource
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictItem> getType(String dictType)
    {
        return sysDictItemMapper.selectByDictId(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        SysDictItemExample example = new SysDictItemExample();
        example.createCriteria().andDictIdEqualTo(dictType).andItemKeyEqualTo(dictValue);
        SysDictItem item = sysDictItemMapper.selectByExample(example).stream().findFirst().orElse(null);
        if (item != null){
            return item.getItemVal();
        }
        return null;
    }
}
