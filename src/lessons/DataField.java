package lessons;


public class DataField {


    private byte[] data;
    private String[] stringHexArray;
    Galileo galileo = new Galileo();


    public DataField(int dataSize) {
        data = new byte[dataSize];
        stringHexArray = new String[dataSize];
    }

    public void showData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "]");
        }
    }

    public byte convertStringToHex(String hexString) {
        byte byteFromHex = (byte)(Integer.parseInt(hexString, 16));
        return byteFromHex;

    }

    public String convertHexToString(byte testbyte) {
        String stringFromHex = Integer.toHexString((testbyte + 256) & 0xFF);
        return stringFromHex;
    }

    public void setDataFromTest(String testString) {
        for (int i = 0; i < testString.length(); i+=2) {
            data[i/2] = convertStringToHex(testString.substring(i,i+2));
        }
    }

    public void showHexData() {
        System.out.println("Length of text array: " + stringHexArray.length);
        for (int i = 0; i < stringHexArray.length; i++) {
            stringHexArray[i] = convertHexToString(data[i]);
            System.out.print("[" + stringHexArray[i] + "]");
        }
    }

    public void showGalilleo() {
        galileo.getHeshStr();
    }

    public String getGallileoValue(String value) {
        String a = galileo.getLengthOfByte(value.toLowerCase());
        return a;
    }


}
