
public class SomeObject {

private static int count = 0;
private static int num = 0;
String name;
private static int i = 0;
SomeObject(String count, String num) {
	SomeObject.count += Integer.parseInt(count);
	SomeObject.num += Integer.parseInt(num);
	i++;
	System.out.println("A new object has been created and it is from line " + i);
}

SomeObject(String z) {
	SomeObject.i += Integer.parseInt(z);
	i++;
	System.out.println("A new object has been created it is number " + i);
}
public static int getCount() {
	// TODO Auto-generated method stub
	return count;
}
public static int updateCount(int count) {
	count ++;
	return count;
	
}
public static int getNum() {
	return num;
}
public static void setNum(int num) {
	SomeObject.num = num;
}



}
