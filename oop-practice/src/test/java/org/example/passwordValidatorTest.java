package org.example;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class passwordValidatorTest {



    @DisplayName("비밀번호가 8자리 이상 12자리 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() ->PasswordValidator.validate("serverwizard"))
            .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 12자 초과하는 경우 IllegalArgument Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce" , "aabbccddeeffg"})
    @Test
    void validatePasswordTest2() {
        assertThatCode(() -> PasswordValidator.validate("dd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자이상 12자 이하여야 합니다.");
    }


    @Test
    void name() {
    }
}
