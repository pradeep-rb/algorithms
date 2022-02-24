package twoptr;

class RemoveDuplicates {

  public static int remove(int[] arr) {
    int i=0;
    int j=1;
    int d = 1;
    while (j < arr.length) {
      while (  arr[i] == arr[j])  {
        j++;
        if (j == arr.length) {
          return  d;
        }
      }
      d++;
      arr[i+1] = arr[j];
      i++; j++;
    }

    return d;
  }


  public static int remove2(int[] arr) {
    int nextNonDuplicate = 1; // index of the next non-duplicate element
    for (int i = 1; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }
    return nextNonDuplicate;
  }

  public static void main(String[] args) {
    System.out.println(RemoveDuplicates.remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
    System.out.println(RemoveDuplicates.remove(new int[] { 2, 2, 2, 11 }));

    System.out.println(RemoveDuplicates.remove2(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
    System.out.println(RemoveDuplicates.remove2(new int[] { 2, 2, 2, 11 }));
  }
}