package util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Util {
	private Util() {
		/* インスタンス化を禁止するため、private化 */
	}

	/*暗号メソッド
	 * String source = "暗号化対象";
	 * return 暗号化された文字列
	 */
	public static String toCode(String source) {


		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);
			return result;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

    ////1988-04-01を1988年04月01日に変える
	public static String formatBirth_date(String date) {
		String[] str = date.split("-", 0);

		return str[0]+"年"+str[1]+"月"+str[2]+"日";
	}

	//create_dateとupdate_dateのフォーマットを整える
	public static String formatUserDate(String date) {
		String[] str = date.split(" ", 0);
		String userDate = formatBirth_date(str[0]);
		String[] tm = str[1].split(":",0);

		return userDate+" "+tm[0]+":"+tm[1]+":"+tm[2].substring(0,2);
	}

	//1988年04月01日を1988-04-01に変える
	public static String formatDate(String date) {

		//test
		//System.out.println(date.substring(0,4)+"-"+date.substring(5,7)+"-"+date.substring(8,10));
		return date.substring(0,4)+"-"+date.substring(5,7)+"-"+date.substring(8,10);
	}

	//文字列がnullの時空白を返す
	//getParameterで取得した値がnullの時、入力欄にnullを表示させない
	public static String nullCheck(String str) {
		if(str==null) {
			return "";
		}else {
			return str;
		}
	}

}
