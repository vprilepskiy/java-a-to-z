package array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 08.11.2017.
 */
public class CombinatoricsRefactor {

    /**
     * Возвращает все возможные набры перестановок.
     *
     * @param array - array.
     * @return - arrays.
     */
    public List<int[]> allVariantsOfPermutations(int[] array) {

        final List<int[]> result = new LinkedList<>();

        // добавим в результирующий набор
        result.add(array);

        // пройти по всем ячейкам кроме последней, т.к. перестановок в последней ячейке не может быть
        for (int i = 0; i < array.length - 1; i++) {

            final List<int[]> tempList = new LinkedList<>();
            tempList.addAll(result);

            // по всем наборам
            for (int[] arr : tempList) {
                final List<int[]> arrays = this.transposition(arr, i);
                result.addAll(arrays);
            }
        }

        return result;
    }


    /**
     * Переместит n-ый элемент в начало, где n-номер возвращаемого массива.
     * <p>
     * Example for [1, 2, 3, 4], return:
     * [2, 1, 3, 4]
     * [3, 1, 2, 4]
     * [4, 1, 2, 3]
     *
     * @param array - array.
     * @return - arrays.
     */
    public List<int[]> transposition(int[] array) {
        final List<int[]> result = new LinkedList<>();

        // итерация по элементам массива
        for (int i = 1; i < array.length; i++) {

            final int[] tempArr = new int[array.length];

            // записать элемент перестановки
            tempArr[0] = array[i];
            // записать из начала массива
            System.arraycopy(array, 0, tempArr, 1, i);
            // записать из конца массива
            System.arraycopy(array, i + 1, tempArr, i + 1, array.length - i - 1);

            // записать вариант перестановки в результирующий рабор
            result.add(tempArr);
        }

        return result;
    }


    /**
     * Выполнит перестановку с определенного элемента.
     * <p>
     * Example for [1, 2, 3, 4], witch begin=1 return:
     * [1, 3, 2, 4]
     * [1, 4, 2, 3]
     * <p>
     * Example for [1, 2, 3, 4], witch begin=2 return:
     * [1, 2, 4, 3]
     *
     * @param array      - array.
     * @param beginIndex - индекс элемента с которого следует начать перестановку.
     * @return - arrays.
     */
    public List<int[]> transposition(int[] array, int beginIndex) {
        final List<int[]> result = new LinkedList<>();

        // элементы из начала массива
        final int[] beginArr = new int[beginIndex];
        System.arraycopy(array, 0, beginArr, 0, beginIndex);

        // элементы из конца массива
        final int[] endArr = new int[array.length - beginIndex];
        System.arraycopy(array, beginIndex, endArr, 0, array.length - beginIndex);

        // получаем массивы с переставлеными элементами
        final List<int[]> endArrays = this.transposition(endArr);

        // добавляем в результат начальные элементы и полученные(переставленные)
        for (int[] end : endArrays) {
            result.add(ArrayUtils.addAll(beginArr, end));
        }

        return result;
    }
}
