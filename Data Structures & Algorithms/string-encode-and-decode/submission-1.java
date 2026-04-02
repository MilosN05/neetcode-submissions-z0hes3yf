class Solution {
    public String encode(List<String> strs) {
        String enkondiranString ="";
        for (String element:strs) {
            enkondiranString+=element + "\\enkod123\\";
        }

        return enkondiranString;
    }

    public List<String> decode(String str) {
        String dekodiranString="";

        List<String> res = new LinkedList<>();
        for (int i=0;i<str.length();i++) {
            dekodiranString += str.charAt(i);
            if (dekodiranString.contains("\\enkod123\\")) {


                int obrisi = dekodiranString.indexOf("\\enkod123\\");
                System.out.println(obrisi);
                res.add(dekodiranString.substring(0, obrisi));
                dekodiranString = "";
            }
        }

        return res;
    }
}
