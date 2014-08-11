package Exam;

public class ArrayIndex {

	public void main(String args[]) {
		int[] myArray = { 1, 1, 2, 2, 3, 4, 5, 6, 4, 3 };
		System.out.println(removeDuplicates(myArray));
	}

	public static int[] removeDuplicates(int[] inArray) {
		int uniqueElems = 0;
		for (int i = 0; i < inArray.length; ++i) {
			if (!seenBefore(i, inArray))
				++uniqueElems;
		}
		int[] uniqueArray = new int[uniqueElems];
		for (int i = 0, index = 0; i < inArray.length; ++i) {
			uniqueArray[index++] = inArray[i];
			if (seenBefore(i, inArray))
				--index;
			if (index == uniqueArray.length)
				break;
		}
		return uniqueArray;
	}

	private static boolean seenBefore(int index, int[] inArray) {
		for (int j = index - 1; j >= 0; --j) {
			if (inArray[index] == inArray[j])
				return true;
		}
		return false;
	}

}
