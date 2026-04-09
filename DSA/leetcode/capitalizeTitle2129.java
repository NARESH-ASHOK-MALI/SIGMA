public class capitalizeTitle2129 {
    public static void main(String[] args) {
        String title = "hi i am naresh";
        System.out.println(capitalizeTitle(title));
    }

    public static String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        char ch=Character.toUpperCase(title.charAt(0));
        sb.append(ch);
        for(int i=1;i<title.length();i++){
            if( title.charAt(i)==' '&&i+1<title.length()-1){
                sb.append(title.charAt(i));
                i++;
            sb.append(Character.toUpperCase(title.charAt(i)));
            } else {
                sb.append(title.charAt(i));
            }
        }
        return sb.toString();
    }

}