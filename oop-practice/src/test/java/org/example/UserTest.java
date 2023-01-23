package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        //Given
        User user = new User();

        //when
        user.initPassword();

        //then
        assertThat(user.getPassword()).isNotNull();

    }
    /*
    * 패스워드가 초기화되는지 테스트 , 성공할수도 실패할수도 있다.
    * RandomPassword가 몇글자일지 우리가컨트롤할수가 없기때문이다.
    *
    *
    * */
}