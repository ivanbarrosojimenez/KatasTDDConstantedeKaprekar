package solucion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContanteKaprekarTest {

    /** The environment. */
    ConstanteKaprekar contanteKaprekar = new ConstanteKaprekar();

    @Test
    void es_numero_con_4_digitos_diferentes() {
        Assertions.assertEquals(true, contanteKaprekar.esNumeroValido("0009"));
        Assertions.assertEquals(true, contanteKaprekar.esNumeroValido("1000"));
        Assertions.assertEquals(true, contanteKaprekar.esNumeroValido("2002"));

    }

    @Test
    void no_es_numero_con_4_digitos_diferentes() {
        Assertions.assertEquals(false, contanteKaprekar.esNumeroValido("0000"));
        Assertions.assertEquals(false, contanteKaprekar.esNumeroValido("999"));
        Assertions.assertEquals(false, contanteKaprekar.esNumeroValido("1"));
        Assertions.assertEquals(false, contanteKaprekar.esNumeroValido("0"));
    }

    @Test
    void es_numero_valido_constante_kaprekar() {
        Assertions.assertEquals(3, contanteKaprekar.comprobarNumero(3524));
        Assertions.assertEquals(5, contanteKaprekar.comprobarNumero(1121));
        Assertions.assertEquals(5, contanteKaprekar.comprobarNumero(111));
        Assertions.assertEquals(4, contanteKaprekar.comprobarNumero(11));
        Assertions.assertEquals(4, contanteKaprekar.comprobarNumero(7));
        Assertions.assertEquals(7, contanteKaprekar.comprobarNumero(1893));
    }

    @Test
    void validar_todos_los_digitos_iguales() {
        Assertions.assertEquals(8, contanteKaprekar.comprobarNumero(1111));
    }

    @Test
    void validar_constante_kaprekar() {
        Assertions.assertEquals(0, contanteKaprekar.comprobarNumero(6174));
    }

    @Test
    void no_es_formato_numero() {
        Assertions.assertEquals(false, contanteKaprekar.esNumeroValido(""));
    }
}
