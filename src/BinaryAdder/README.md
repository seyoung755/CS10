CS10 과정을 위한 gist입니다.

### Revision
- Revision 2 : 미션 1 구현 완료. Gate class를 통해서 각 gate의 연산결과를 반환하도록 구현하였습니다.
  ```java
  public class Gate {

    public boolean andGate(boolean bitA, boolean bitB) {
        return bitA && bitB;
    }

    public boolean orGate(boolean bitA, boolean bitB) {
        return bitA || bitB;
    }

    public boolean nandGate(boolean bitA, boolean bitB) {
        return !(bitA && bitB);
    }

    public boolean xorGate(boolean bitA, boolean bitB) {
        return (bitA || bitB) && !(bitA && bitB);
    }}
- Revision 4 : 미션 2의 반쪽 덧셈 구현 완료. Gate class를 조합하여 자리올림과 덧셈을 구하는 halfAdder 함수를 구현했습니다.
  ```java
      public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {gate.andGate(bitA, bitB), gate.xorGate(bitA, bitB)};
        return answer;
    }
    
- Revision 5 : 미션 2의 전가산기 구현 완료. 앞에서 만든 반가산기를 조합하여 전가산기 기능을 구현했습니다.
  ```java
      public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] h1 = this.halfAdder(bitA, bitB);
        boolean[] h2 = this.halfAdder(h1[1], carry);

        boolean[] answer = {gate.orGate(h1[0], h2[0]), h2[1]};
        return answer;
    }

- Revision 6 : 미션 3의 바이트 덧셈 구현 완료. 앞에서 만든 전가산기를 이용하여 계산했습니다.
  만약 길이가 서로 다른 비트가 들어오거나 1바이트보다 작거나 큰 비트가 들어와도 계산 가능하도록 구현했습니다.
  코드 가독성이 조금 떨어져 계산방식의 개선이 필요하다고 생각합니다.
  ```java
  public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int min_len = Math.min(byteA.length, byteB.length);
        int max_len = Math.max(byteA.length, byteB.length);
        boolean carry = false;

        int answer_len = max_len+1;

        if (min_len != max_len) {
            answer_len = max_len;
        }

        boolean[] answer = new boolean[answer_len];

        for (int i = 0 ; i < min_len ; i++) {
            boolean bitA=byteA[i], bitB=byteB[i];
            boolean[] result = this.fullAdder(bitA, bitB, carry);
            carry = result[0];
            answer[i] = result[1];
        }

        if (max_len != min_len) {
            for (int j = min_len; j < max_len; j++) {
                if (byteA.length > byteB.length) {
                    boolean bitA = byteA[j], bitB = false;
                    boolean[] result = this.fullAdder(bitA, bitB, carry);
                    carry = result[0];
                    answer[j] = result[1];
                } else {
                    boolean bitA = false, bitB = byteB[j];
                    boolean[] result = this.fullAdder(bitA, bitB, carry);
                    carry = result[0];
                    answer[j] = result[1];
                }
            }
        } else
        {
            answer[max_len] = carry;
        }

        return answer;
    }
    
- Revision 7 : 진법 변환기 중 이진수로 변환하는 함수를 구현하였습니다. 숫자 크기에 따라 배열의 크기를 유동적으로 정하기 위해 ArrayList를 사용하였습니다.
  ```java
  package BinaryAdder;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class Convertor {

      public void dec2bin(int decimal) {
          List<Boolean> answer = new ArrayList<Boolean>();
          while (decimal > 0) {
              boolean b = (decimal % 2) != 0;
              answer.add(b);
              decimal /= 2;
          }
          Boolean[] arr = new Boolean[answer.size()];
          printBin(answer.toArray(arr));
      }

      public void printBin(Boolean[] arr) {
          System.out.println(Arrays.toString(arr));
      }

      public static void main(String[] args) {
          Convertor c = new Convertor();
          int decimal = 256;
          c.dec2bin(decimal);

      }
  }

- Revision 8 : 이진수를 십진수로 변환하는 함수를 구현하였습니다. 출력 함수를 따로 만들어서 예시처럼 출력되도록 구현했습니다.
  ```java
  package BinaryAdder;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class Convertor {

      public void dec2bin(int decimal) {
          List<Boolean> answer = new ArrayList<Boolean>();
          int dec = decimal;
          while (dec > 0) {
              boolean b = (dec % 2) != 0;
              answer.add(b);
              dec /= 2;
          }
          Boolean[] arr = new Boolean[answer.size()];
          printBin(decimal, answer.toArray(arr));
      }

      public void bin2dec(boolean[] bin) {
          int i = 1, answer = 0;
          for (boolean b : bin) {
              if (b) {
                  answer += i;
              }

              i *= 2;
          }
          printDec(bin, answer);
      }

      public void printBin(int decimal, Boolean[] answer) {
          System.out.println("입력 = "+decimal);
          System.out.println("출력 = "+Arrays.toString(answer));
      }

      public void printDec(boolean[] bin, int answer) {
          System.out.println("입력 = "+Arrays.toString(bin));
          System.out.println("출력 = "+answer);
      }


      public static void main(String[] args) {
          Convertor c = new Convertor();
          int decimal = 256;
          c.dec2bin(decimal);
          boolean[] bin = {true, true, true, true, true};
          c.bin2dec(bin);

      }
  }

- Revision 10 : 바이트 덧셈의 출력 형식을 수정하였습니다.
  ```java
        BinaryAdder binaryAdder = new BinaryAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};

        boolean[] answer = binaryAdder.byteAdder(byteA, byteB);

        System.out.println("byte A = "+Arrays.toString(byteA));
        System.out.println("byte B = "+Arrays.toString(byteB));
        System.out.println("결과 = "+Arrays.toString(answer));

- Revision 11 : 바이트 덧셈의 구현 방식을 수정하였습니다. 가변 배열로 하려니 복잡해지는 것 같아서 ArrayList를 사용하여 길이가 서로 다른 비트의 덧셈을 편하게 할 수 있도록 하였습니다.
  ```java
  public Boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int min_len = Math.min(byteA.length, byteB.length);
        int max_len = Math.max(byteA.length, byteB.length);
        boolean carry = false;

        List<Boolean> answer = new ArrayList<Boolean>();

        for (int i = 0; i < min_len; i++) {
            boolean bitA = byteA[i], bitB = byteB[i];
            boolean[] result = this.fullAdder(bitA, bitB, carry);
            carry = result[0];
            answer.add(result[1]);
        }

        if (max_len != min_len) {
            for (int j = min_len; j < max_len; j++) {
                if (byteA.length > byteB.length) {
                    boolean bitA = byteA[j], bitB = false;
                    boolean[] result = this.fullAdder(bitA, bitB, carry);
                    carry = result[0];
                    answer.add(result[1]);
                } else {
                    boolean bitA = false, bitB = byteB[j];
                    boolean[] result = this.fullAdder(bitA, bitB, carry);
                    carry = result[0];
                    answer.add(result[1]);
                }
            }
        } else {
            answer.add(carry);
        }

        return answer.toArray(new Boolean[answer.size()]);
    }

- Revision 13 : 바이트의 길이를 비교하는 부분에 삼항 연산자를 사용하여 반복되는 부분을 줄이는 식으로 리팩터링하였습니다.

- Revision 14 : 테스트 코드를 사용하여 각 메인함수에서 검증하던 방식을 개선하였습니다. 또한 미션별로 확인하기 쉽게 파일을 분리하였습니다.

- Revision 15 : 16진수 변환 코드를 추가하고 테스트 코드 및 일부 코드를 수정했습니다. 
  