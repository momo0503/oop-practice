package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {


    @Test
    @DisplayName("메뉴 이름에 해당하는 메뉴를 반환")
    void chooseTest() {

        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("돈까스",5000));
        list.add(new MenuItem("냉면",7000));

        Menu menu = new Menu(list);

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스",5000));
    }



}
