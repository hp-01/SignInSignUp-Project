/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validater;

/**
 *
 * @author harsh
 */
public class Random6 {
    public static String randomValue()
    {
                int n1 = Integer.parseInt(("" + Long.parseLong(("" + Math.random()).substring(2))).substring(0, 6));
                return Integer.toString(n1);
    }
    public static void main(String[] args) throws InterruptedException {
       /* String rand;
        String value; Boolean c = true;
        int i = 0;
        while(i<=10 && c)
        {
            rand = randomValue();
            System.out.println("Value "+rand);
            while(true)
            {
            Scanner sc = new Scanner(System.in);
            value = sc.next();
            if(value.equals(rand)) 
            {
                System.out.println("Correct");
                c = false;
                break;
            }
            else System.out.println("Incorrect");
            }
          Thread.sleep(1000);
    }*/
  }        
    public boolean ifCorrect(String input) throws InterruptedException
        {
        String rand;
        String value; Boolean c = true;
        int i = 0;
        while(i<=10 && c)
        {
            rand = randomValue();
            System.out.println("Value "+rand);
            while(true)
            {
            if(input.equals(rand)) 
            {
                System.out.println("Correct");
                c = false;
                break;
            }
            else System.out.println("Incorrect");
            }
            Thread.sleep(10000);
            i++;
          }
        return false;
        }

}
