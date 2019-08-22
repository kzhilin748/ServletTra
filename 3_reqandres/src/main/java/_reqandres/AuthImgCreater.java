package _reqandres;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AuthImgCreater{
    public static final int CODE_len=6;//驗證碼長度
    public static final int EACHCODE_Wid=20;
    public static final int EACHCODE_Height=25;
    public static final int GAP=5;
    public static final int Img_Width=CODE_len*(EACHCODE_Wid+GAP);
    public static final int Img_Height=EACHCODE_Height;
	public static final char[] char_list = {'0','1', '2', '3', '4', '5', '6', '7', '8',
        '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    
    /*
    *   生成回傳驗證碼
    *   @return String  
    */
    public String getAuthcode(){
        StringBuffer buf=new StringBuffer();
        Random seed = new Random();
        for(int i=0;i<=CODE_len;i++){
            buf.append(char_list[seed.nextInt(char_list.length)]);
        }
        return buf.toString();
    } 
    /*
    *   生成並回傳圖片
    *   ＠return BufferedImage
    */
    public BufferedImage  getSuthImg(String Authstring){
        //設定圖片長寬高跟ＲＧＢ編碼
        BufferedImage img=new BufferedImage(Img_Width,EACHCODE_Height,BufferedImage.TYPE_3BYTE_BGR);
        //取得ＩＭＧ的畫筆
        Graphics canvas=img.getGraphics();
        //設定背景色
        canvas.setColor(Color.BLACK);
        //將黑色填滿矩形
        canvas.fillRect(0, 0, Img_Width, Img_Height);
        //設定畫筆顏色用來寫字
        canvas.setColor(Color.white);
        canvas.setFont(new Font("宋体", Font.PLAIN, EACHCODE_Height + 5));
        int codeshift=0;
        for(char tmp: Authstring.toCharArray()){
            canvas.drawString(tmp+"", codeshift*(EACHCODE_Wid+GAP), Img_Height);
            codeshift++;
        }
        return img;

    }
}