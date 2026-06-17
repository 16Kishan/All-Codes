class Solution {
    public String toGoatLatin(String sentence) 
    {
        int front = 0;
        int move = 0;
        int rear = sentence.length();

        int count = 1;

        StringBuilder result = new StringBuilder();

        while(front < rear)
        {
            while(move < rear && sentence.charAt(move) != ' ')
            {
                move++;
            }

            String word = sentence.substring(front , move);

            move = move + 1;
            front = move;

            StringBuilder sb = new StringBuilder(word);

            if(isVowel(sb.charAt(0)))
            {
                sb.append("ma");
            }
            else 
            {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                sb.append("ma");
            }

            
            for(int i=0;i<count;i++)
            {
                sb.append('a');
            }

            count++;

            result.append(sb);

            if(front < rear)
            {
                result.append(" ");
            }
        }

        return result.toString();
    }


    public boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}