package TP1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    Calculator calculadora = new Calculator_api();
    BCD bcd = new BCD();
    Ascii ascii = new Ascii();

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
    public void testMultBinaria(){
        String a1 = "1011";
        String b1 = "0110";
        String resultadoEsperado1 = "1000010";
        assertEquals(resultadoEsperado1, calculadora.mult(a1,b1));
    }

    @Test
    public void testRestaBinaria() {
        String a1 = "01011";
        String b1 = "0101";
        String resultadoEsperado1 = "0110";
        String a2 = "000000";
        String b2 = "111111";
        String resultadoEsperado2= "00001";
        String resultado1 = calculadora.sub(a1, b1);
        assertEquals(resultadoEsperado1, resultado1);
        assertEquals(resultadoEsperado2, calculadora.sub(a2,b2));
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
    public void testHexadecimalABinario() {
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

    @Test
    public void testIntToBinary() {
        assertEquals("0", bcd.encode(0));
        assertEquals("1", bcd.encode(1));
        assertEquals("10", bcd.encode(2));
        assertEquals("11", bcd.encode(3));
        assertEquals("101", bcd.encode(5));
        assertEquals("1101", bcd.encode(13));
        assertEquals("11111111", bcd.encode(255));
    }
    @Test
    public void testBinaryToInt() {
        assertEquals(0, bcd.decode("0"));
        assertEquals(1, bcd.decode("1"));
        assertEquals(2, bcd.decode("10"));
        assertEquals(3, bcd.decode("11"));
        assertEquals(5, bcd.decode("101"));
        assertEquals(13, bcd.decode("1101"));
        assertEquals(255, bcd.decode("11111111"));
    }

    @Test
    public void testBinaryToAscii() {
        assertEquals("Alca", ascii.encode("01000001011011000110001101100001") );
        assertEquals("Joafi", ascii.encode("0100101001101111011000010110011001101001"));
        assertEquals("Quitos", ascii.encode("010100010111010101101001011101000110111101110011"));
        assertEquals("Pepe", ascii.encode("01010000011001010111000001100101"));
        assertEquals("Santi", ascii.encode("0101001101100001011011100111010001101001"));
    }

    @Test
    public void testAsciiToBinary() {
        assertEquals("01000001011011000110001101100001", ascii.encode("Alca") );
        assertEquals("0100101001101111011000010110011001101001", ascii.encode("Joafi") );
        assertEquals("010100010111010101101001011101000110111101110011", ascii.encode("Quitos") );
        assertEquals("01010000011001010111000001100101", ascii.encode("Pepe") );
        assertEquals("0101001101100001011011100111010001101001", ascii.encode("Santi") );


    }
}
