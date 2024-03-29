package com.scs.web.space.api.mapper;

import com.scs.web.space.api.SpaceApiApplication;
import com.scs.web.space.api.domain.entity.Notes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = SpaceApiApplication.class)
class NotesMapperTest {
    @Resource
    private NotesMapper notesMapper;
    @Test
    void getByUserId() throws SQLException {

    }

    @Test
    void getNotesById() throws SQLException {

    }

    @Test
    void insertLog() {
    }

    @Test
    void batchInsert() {
    }

    @Test
    void updateLog() {
    }

    @Test
    void batchDelete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void selectNotesByUserId() throws SQLException {
       List<Map> mapList = notesMapper.getByUserId(17, 1, 3);
        System.out.println(mapList.size());
    }

    @Test
    void testGetNotesById() throws SQLException {
    }

    @Test
    void testGetNotesById1() throws SQLException {
        Notes notes = notesMapper.getNotesById(17);
        System.out.println(notes);
    }

    @Test
    void testGetNotesById2() throws SQLException {
        Notes notes = notesMapper.getNotesById(17);
        System.out.println(notes);
    }

    @Test
    void getById() throws SQLException {
    }
}