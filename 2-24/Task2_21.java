/**
* Task2-21 : 課題内容
* Java2章 中間チェックテスト理解/定着課題
*
* 問①〜問③の空欄を埋めて、指示通りに出力してください。
*/
public class Task2_21{
    public static void main(String[] args) {
        /*
         * 問①
         * int型の変数 x と y を宣言し、それぞれ12と5を代入して、
         * 次の演算結果を表示してください：
         * ・x と y の和
         * ・x と y の差
         * ・x と y の積
         * ・x と y の商
         * ・x を y で割った余り
         */

        int x =12;
        int y =5;

        System.out.println("和:"+ (x+y));
        System.out.println("差:"+ (x-y));
        System.out.println("積:"+ (x*y));
        System.out.println("商:"+ (x/y));
        System.out.println("余り:"+ (x%y));

        /*
         * 問②
         * int型の配列を宣言し、1から18までの偶数を格納して、
         * ループを使用して順番に表示してください。
         */

        int[] arr = {2,4,6,8,10,12,14,16,18};

        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        /*
         * 問③
         * int型の配列「numbers」内の奇数の合計を、
         * メソッド「sumOddNumbers」を使って表示してください。
         * ただし、0は偶数として扱います。
         */
        int[] numbers = {2, 4, 5, 7, 9, 10, 12, 13, 15};
        int add = sumOddNumbers(numbers);
        System.out.println("奇数の合計： " + add);
    }

    public static int sumOddNumbers(int[] numbers) {
        int add = 0;
        for (int i = 0; i < numbers.length; i++) {
            // 問③ 奇数かどうかの判定を行い、奇数のみ加算してください。
            if (numbers[i] %2 == 1 ) {
                add += numbers[i];
            }
        }
        return add;
    }
}