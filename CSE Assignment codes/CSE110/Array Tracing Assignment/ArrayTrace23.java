public class ArrayTrace23{
public static void main(String [] args){
int i = 0;
int j = 1;
String [ ][ ] twoD1 = new String [3][3];
int [ ][ ] twoD2 = new int [3][3];
twoD1[0][0] = "b";
twoD1[0][1] = "c";
twoD1[0][2] = "d";
twoD1[1][0] = "e";
twoD1[1][1] = "p";
twoD1[1][2] = "x";
twoD1[2][0] = "y";
twoD1[2][1] = "g";
twoD1[2][2] = "h";
twoD2[0][0] = 11;
twoD2[0][1] = 12;
twoD2[0][2] = 32;
twoD2[1][0] = 23;
twoD2[1][1] = 12;
twoD2[1][2] = 9;
twoD2[2][0] = 26;
twoD2[2][1] = 32;
twoD2[2][2] = 44;
while (i < 3){
j = 2;
while (j >= 0){
System.out.println(twoD1[i][j] + twoD2[j][i]);
j--;
}
++i;
}
}
}