package com.scs.web.space.api.service;

import com.scs.web.space.api.domain.dto.AlbumDto;
import com.scs.web.space.api.util.Result;


/**
 * @ClassName AlbumService
 * @Description 相册服务接口
 * @Author wf
 * @Date 2019/12/1
 **/
public interface AlbumService {
    /**
     * 新增相册
     * @param albumDto
     * @return
     */
    Result insertAlbum(AlbumDto albumDto);

    /**
     * 查询所有相册
     * @return
     */
    Result getAlbum();

    Result getAccountByUserId(long id);

    /**
     * 查询个人所有相册
     * @param id
     * @return
     */
    Result getByUserId(long id);

    /**
     * 删除相册
     * @param id
     * @return
     */
    Result deleteByName(int id);
}
