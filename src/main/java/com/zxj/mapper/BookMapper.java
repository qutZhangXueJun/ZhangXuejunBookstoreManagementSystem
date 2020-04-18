package com.zxj.mapper;


import com.zxj.pojo.Book;
import com.zxj.pojo.BookSub;
import java.util.List;
import java.util.Map;

/**功能描述：图书持久层接口

 */
public interface BookMapper {

    //查看图书列表

    List<Book> queryBookList(Map<String, Object> map);

    //借阅图书
    void addSubBook(Map<String, Object> map);

    //新增图书
    void addBook(Map<String, Object> map);

    //编辑图书
    void editBook(Map<String, Object> map);

    //删除图书
    void delBook(Map<String, Object> map);

    //归还图书
    void returnSubBook(Map<String, Object> map);

    //查看借阅图书列表
    List<BookSub> querySub(Map<String, Object> map);

    //更新图书库存
    void updateInventtories(Map<String, Object> map);
}
