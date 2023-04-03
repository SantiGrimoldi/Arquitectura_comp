package TP1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    Calculator calculadora = new Calculator_api();
    @Test
    public void testSumaBinaria() {
        String a1 = "10101010";
        String b1 = "11001100";
        String resultadoEsperado1 = "101110110";
        String a2 = "1111";
        String b2 = "10";
        String resultadoEsperado2 = "10001";
        String a3 = "10101010";
        String b3 = "11111111";
        String resultadoEsperado3 = "110101001";


        assertEquals(resultadoEsperado1, calculadora.sum(a1, b1));
        assertEquals(resultadoEsperado2, calculadora.sum(a2, b2));
        assertEquals(resultadoEsperado3, calculadora.sum(a3, b3));
    }
    @Test
    public void testRestaBinaria() {
        String a1 = "10101010";
        String b1 = "11001100";
        //-64 + 16 + 8 + 4 + 2
        String resultadoEsperado1 = "1011110";

        String a3 = "11111111";
        String b3 = "1";
        String resultadoEsperado3 = "11111110";

        String resultado1 = calculadora.sub(a1, b1);
        String resultado3 = calculadora.sub(a3, b3);

        assertEquals(resultadoEsperado1, resultado1);
        assertEquals(resultadoEsperado3, resultado3);
    }
        @Test
        public void testBinarioAHexadecimal() {
            String binario1 = "10101010";
            String resultadoEsperado1 = "AA";
            String binario2 = "110011000100";
            String resultadoEsperado2 = "CC4";
            String binario3 = "1111111111111111";
            String resultadoEsperado3 = "FFFF";

            assertEquals(resultadoEsperado1, calculadora.toHex(binario1));
            assertEquals(resultadoEsperado2, calculadora.toHex(binario2));
            assertEquals(resultadoEsperado3, calculadora.toHex(binario3));
        }
        @Test
    public void testHexadecimalABinario(){
            String binario1 = "10101010";
            String resultadoEsperado1 = "AA";
            String binario2 = "110011000100";
            String resultadoEsperado2 = "CC4";
            String binario3 = "1111111111111111";
            String resultadoEsperado3 = "FFFF";
            assertEquals(binario1, calculadora.fromHex(resultadoEsperado1));
            assertEquals(binario2, calculadora.fromHex(resultadoEsperado2));
            assertEquals(binario3, calculadora.fromHex(resultadoEsperado3));
        }
    }
