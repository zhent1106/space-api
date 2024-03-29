package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Notes;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NotesMapper
 * @Description 日志Mapper
 * @Author wf
 * @Date 2019/12/2
 **/
public interface NotesMapper {

    @Results(id = "notes",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "comments",column = "comments"),
            @Result(property = "likes",column = "likes"),
            @Result(property = "editStatus",column = "edit_status"),
            @Result(property = "accessStatus",column = "access_status"),
            @Result(property = "forwardStatus",column = "forward_status"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "avatar",column = "avatar")
    })
    /**查询个人日志列表
     * @param id
     * @return List<map>
     * @throws SQLException
     */
    @Select("SELECT t1.*,t2.nickname,t2.avatar FROM t_notes t1 " +
            " LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE user_id = #{userId} " +
            "LIMIT ${pageSize*(currentPage-1)},#{pageSize}")
    List<Map> getByUserId(int userId,int currentPage, int pageSize) throws SQLException;

   /* @ResultMap("notes")*/
    /**
     * 查询日志详情
     * @param
     * @return Map
     * @throws SQLException
     */

    @Select("SELECT * FROM t_notes WHERE id = #{id} ")
    Notes getNotesById(@Param("id") int id) throws SQLException;


    /**
     * 查询所有用户所有的日志
     * @return List<notes>
     * @throws SQLException
     */
    @Select("SELECT * FROM t_notes ORDER BY create_time ASC")
    Notes getAllNotes() throws SQLException;

    /**
     * 新增日志信息
     * @param notes
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT INTO t_notes(id,user_id,title,content,edit_status,access_status,forward_status,create_time)" +
            "VALUES (null,#{userId},#{title},#{content},#{editStatus},#{accessStatus},#{forwardStatus},#{createTime})")
    int insertLog(Notes notes) throws SQLException;
    /**
     * 根据日志id更新新日志信息
     * @param log
     * @return int
     * @throws SQLException
     */
    @Update("UPDATE t_notes SET title=#{title}, content=#{content},edit_status=#{editStatus}," +
            "access_status=#{accessStatus},forward_status=#{forwardStatus},create_time=#{createTime}" +
            "WHERE id=#{id}")
    int updateLog(Notes log) throws SQLException;
    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM t_notes WHERE id = #{id}")
    int deleteById(int id);

    /**
     * 根据用户id查询所有日志,与用户进行联查
     * @param userId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_notes  WHERE user_id = #{userId} ")
    List<Notes> selectNotesByUserId(@Param("userId") int userId)throws SQLException;


    /**
     * user、comment、notes三表联查
     * @param id
     * @return
     * @throws SQLException
     */
    @Results({
            @Result(property = "comment", column = "id",
                    many = @Many(select = "com.scs.web.space.api.mapper.CommentMapper.getByUserId")),
    })
    @Select("SELECT * FROM t_notes WHERE id = #{id} ")

    Notes getByNotesId(@Param("id") int id)throws SQLException;
}
