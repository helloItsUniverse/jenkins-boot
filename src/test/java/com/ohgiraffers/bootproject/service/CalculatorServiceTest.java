package com.ohgiraffers.bootproject.service;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    /* 설명. 테스트코드의 given 에 해당됨 */
    private static Stream<Arguments> provideDTOSource() {
        return Stream.of(
                Arguments.of(new CalculatorDTO(1, 2)),
                Arguments.of(new CalculatorDTO(3, 5)),
                Arguments.of(new CalculatorDTO(10, -2)),
                Arguments.of(new CalculatorDTO(10, 3)),
                Arguments.of(new CalculatorDTO(10, 5)),
                Arguments.of(new CalculatorDTO(2, 3)),
                Arguments.of(new CalculatorDTO(4, 3)),
                Arguments.of(new CalculatorDTO(5, 5)),
                Arguments.of(new CalculatorDTO(6, 6))


        );
    }

    @DisplayName("두 수의 합 구하기 테스트")
    @ParameterizedTest
    @MethodSource("provideDTOSource")
    void testPlus(CalculatorDTO input) {

        // when
        int expected = input.getNum1() + input.getNum2();

        // then
        int actual = calculatorService.plus(input);

        Assertions.assertEquals(expected, actual);
    }
}