package com.study.datajpa.repository;

import com.study.datajpa.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void save() throws Exception {
        // given
        Item item = new Item("A");
        itemRepository.save(item);
        // when

        // then
    }

}