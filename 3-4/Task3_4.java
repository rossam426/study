/**
* Task3-4 : 課題内容
* 理解/定着課題⑤
*
* 問①〜問④の空欄を埋めて、指示通りに出力してください。
*/
public class Task3_4 {
    public static void main(String[] args) {
        /*
         * 問①
         * int型の変数 a と b を宣言し、それぞれ15と4を代入して、
         * 次の演算結果を表示してください：
         * ・a と b の和
         * ・a と b の差
         * ・a と b の積
         * ・a と b の商
         * ・a を b で割った余り
         */

        int a =15;
        int b =4;

        System.out.println("和:"+(a+b));
        System.out.println("差:"+(a-b));
        System.out.println("積:"+(a*b));
        System.out.println("商:"+(a/b));
        System.out.println("余り:"+(a%b));


        /*
         * 問②
         * int型の配列を宣言し、2から20までの偶数を格納して、
         * for文で順番に表示してください。
         */

        int[] arr ={2,4,6,8,10,12,14,16,18,20};

        for(int i =0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        /*
         * 問③
         * int型の配列「numbers」内の奇数の合計を、
         * メソッド「sumOddNumbers」を使って表示してください。
         * ただし、0は偶数として扱います。
         */
        int[] numbers = {1, 2, 4, 7, 9, 11, 12, 14, 15, 18};
        int oddTotal = sumOddNumbers(numbers);
        System.out.println("奇数の合計： " + oddTotal);

        /*
         * 問④
         * 同じ配列「numbers」内の偶数の合計を、
         * メソッド「sumEvenNumbers」を使って表示してください。
         */
        int evenTotal = sumEvenNumbers(numbers);
        System.out.println("偶数の合計： " + evenTotal);
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

    public static int sumEvenNumbers(int[] numbers) {
        int add = 0;
        for (int i = 0; i < numbers.length; i++) {
            // 問④ 偶数かどうかの判定を行い、偶数のみ加算してください。
            if (numbers[i] %2 == 0 ) {
                add += numbers[i];
            }
        }
        return add;
    }
}