package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SampleTest {

    private final Sample sample = new Sample();

    @ParameterizedTest
    @CsvSource({
        "1, 4, 5",
        "144, 1200, 1344",
        "10, 321, 331",
        "3, 3, 6"
    })
    void sum_two_positive_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, num1, num2);
        Assertions.assertThat(result).as("Somme de deux entiers positifs").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "1, -4, -3",
        "-4, 5, 1",
        "-1, 3, 2"
    })
    void sum_positive_negative_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, num1, num2);
        Assertions.assertThat(result).as("Somme d'un entier positif avec un entier négatif").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "-1, -4, -5",
        "-4, -14555, -14559",
        "-1012223, -1477, -1013700"
    })
    void sum_two_negative_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, num1, num2);
        Assertions.assertThat(result).as("Somme de deux entiers négatifs").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 4, 4",
        "144, 1200, 172800",
        "10, 321, 3210",
        "3, 3, 9"
    })
    void multiply_two_positive_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, num1, num2);
        Assertions.assertThat(result).as("Produit de deux entiers positifs").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "1, -4, -4",
        "-4, 5, -20",
        "-1, 3, -3"
    })
    void multiply_positive_negative_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, num1, num2);
        Assertions.assertThat(result).as("Produit d'un entier positif avec un entier négatif").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "-1, -4, 4",
        "-4, -14555, 58220",
        "-1012223, -51, 51623373"
    })
    void multiply_two_negative_integers(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, num1, num2);
        Assertions.assertThat(result).as("Produit de deux entiers négatifs").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "-144, 0, -144",
        "120, 0, 120",
        "0, 0, 0"
    })
    void sum_integer_with_zero(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, num1, num2);
        Assertions.assertThat(result).as("Somme d'un entier avec un entier nul (zéro)").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "-144, 0, 0",
        "120, 0, 0",
        "0, 0, 0"
    })
    void multiply_integer_with_zero(int num1, int num2, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, num1, num2);
        Assertions.assertThat(result).as("Produit d'un entier avec un entier nul (zéro)").isEqualTo(expectedResult);
    }
}
