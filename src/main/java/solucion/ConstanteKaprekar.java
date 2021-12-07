package solucion;

import java.util.Arrays;

public class ConstanteKaprekar {

    private static final int CONSTANTE_KAPREKAR = 6174;
    private static final int DIGITOS_REPETIDOS = 8;
    private static final int ES_CONSTANTE_K = 0;

    private String numero;

    private String numeroAscendente;
    private String numeroDescendente;

    public int comprobarNumero(int numero) {
        if (numero == CONSTANTE_KAPREKAR)
            return ES_CONSTANTE_K;
        if (!esNumeroValido(convertirAString(numero))) {
            return DIGITOS_REPETIDOS;
        }
        this.numero = convertirAString(numero);
        return esConstanteKaprekar();
    }

    public boolean esNumeroValido(String numero) {
        return esNumero(numero)
                && tiene4Digitos(numero)
                && tiene2DigitosDiferentes(numero);
    }

    private boolean esNumero(String numero) {
        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean tiene2DigitosDiferentes(String numero) {
        int[] arrayDigitos = obtenerArrayDigitos(numero);
        return !(arrayDigitos[0] == arrayDigitos[1] && arrayDigitos[1] == arrayDigitos[2]
                && arrayDigitos[2] == arrayDigitos[3]);
    }

    private int[] obtenerArrayDigitos(String numero) {
        int[] arrayDigitos = new int[4];
        arrayDigitos[0] = Integer.parseInt(numero.substring(0, 1));
        arrayDigitos[1] = Integer.parseInt(numero.substring(1, 2));
        arrayDigitos[2] = Integer.parseInt(numero.substring(2, 3));
        arrayDigitos[3] = Integer.parseInt(numero.substring(3, 4));
        return arrayDigitos;
    }

    private boolean tiene4Digitos(String numero) {
        return numero.length() == 4;
    }

    private String convertirAString(int numero) {
        String resultado = "";
        if (numero < 10) {
            return "000" + numero;
        } else if (numero < 100) {
            return "00" + numero;
        } else if (numero < 1000) {
            return "0" + numero;
        }
        return numero + "";
    }

    private String obtenerOrdenAscendente(String numero) {
        int[] digitos = obtenerArrayDigitos(numero);
        Arrays.sort(digitos);
        return arrayToString(digitos);
    }

    private String obtenerOrdenDescendente(String numero) {
        int[] digitos = obtenerArrayDigitos(numero);
        Arrays.sort(digitos);
        int[] digitosDesc = new int[4];
        for (int i = digitos.length - 1, j = 0; i >= 0; i--, j++) {
            digitosDesc[j] = digitos[i];
        }
        return arrayToString(digitosDesc);
    }

    private String arrayToString(int[] digitos) {
        StringBuilder resultado = new StringBuilder();
        for (int digito : digitos) {
            resultado.append(digito);
        }
        return resultado.toString();
    }

    private int esConstanteKaprekar() {
        int resultado = 0;
        while (!numero.equals("6174")) {
            numeroAscendente = obtenerOrdenAscendente(numero);
            numeroDescendente = obtenerOrdenDescendente(numero);
            int result = (Integer.parseInt(numeroDescendente)) - (Integer.parseInt(numeroAscendente));
            numero = convertirAString(result);
            resultado++;
        }

        return resultado;

    }

}
