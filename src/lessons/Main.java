package lessons;

public class Main {
    public static void main(String[] args) {
        String str = "0132C3";
        DataField dataField = new DataField(str.length()/2);
        dataField.showData();

        dataField.setDataFromTest(str);
        dataField.showData();
        dataField.showHexData();

        System.out.println();

        dataField.showGalilleo();


        System.out.println("--------------------------");
        String d = dataField.getGallileoValue("B6k");
        System.out.println(d);


    }
}
