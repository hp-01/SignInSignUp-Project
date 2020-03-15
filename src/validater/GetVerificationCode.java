/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validater;

import java.util.regex.Pattern;

/**
 *
 * @author harsh
 */
public class GetVerificationCode {
    public static String code(String content)
    {
        String value = content.replaceAll("[^0-9]", "").toString();
        return value;
    }
}
