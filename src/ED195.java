public class ED195 {

    public static boolean balanced(String s){
        if (s.length() % 2 != 0) return false;
        int parent = 0;
        int sparent = 0;
        int index = -1;
        int[] typeopen = new int[s.length() / 2];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                parent++;
                index++;
                typeopen[index] = 1;
                if (index >= s.length() / 2) return false;

            } else if (c == ')') {
                if (typeopen[index] == 2 || typeopen[index] == 0) return false;
                parent--;
                if (parent < 0) return false;
                typeopen[index] = 0;
                index--;


            } else if (c == '[') {
                sparent++;
                index++;
                typeopen[index] = 2;
                if (index >= s.length() / 2) return false;

            } else if (c == ']') {
                if (typeopen[index] == 1 || typeopen[index] == 0) return false;
                sparent--;
                if (sparent < 0) return false;
                typeopen[index] = 0;
                index--;

            }
        }
        return sparent == parent && parent == 0;
    }
}
