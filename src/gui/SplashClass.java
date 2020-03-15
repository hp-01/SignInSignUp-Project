package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harsh
 */
public class SplashClass {
    public static void main(String[] args)
    {
        Splash sp = new Splash();
        sp.setVisible(true);
        HomeForm hf = new HomeForm();
        try{
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(20);
                sp.jProgressBar1.setValue(i);
                if(i==100)
                {
                    sp.dispose();
                    sp.setVisible(false);
                    hf.setVisible(true);

                    }
                }
            }           
        
        catch(InterruptedException e)
        {
    }
    }
}
