/* Импорт основного пакета */
package IS; 
/* Импорт пакетов, необходимых для работы тестов */
import org.junit.Test; 

import junit.framework.TestCase; 
/* Объявляем класс первого теста для проверки работы программы */
public class KalaevTestCalculatorApp1 extends TestCase { 
/* Описание действий внутри метода теста (1 проверка) */
@Test 
public void test() throws InterruptedException{ 
/* Создание объекта класса калькулятора */
Calculator calcTest = new Calculator(); 
/* Нажатие на кнопку "Зав.Кафедрой" */
calcTest.bCathedra.doClick(); 
/* Ввод значения в первое поле (Количество учеников) */
calcTest.textField1.setText("250"); 
/* Ввод значения во второе поле (Количество учеников на руководителя) */
calcTest.textField2.setText("5");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры)*/
calcTest.textField3.setText("49"); 
/* Нажатие кнопки "Провести рассчет" */
calcTest.bExecute.doClick(); 
/* Проверка соответствия выходных данных с данными теста */
assertEquals(calcTest.textField4.getText(), "Необходимы дипломные руководители в количестве 50 чел.: 49 чел. с кафедры и 1 чел. не с кафедры."); 
} 
/* Описание действий внутри метода теста (2 проверка) */
@Test 
public void test2() throws InterruptedException{ 
/* Создание объекта класса калькулятора */
Calculator calcTest = new Calculator(); 
/* Нажатие на кнопку "Зав. Кафедрой" */
calcTest.bCathedra.doClick(); 
/* Ввод значения в первое поле (Количество учеников) */
calcTest.textField1.setText("3");
/* Ввод значения во второе поле (Количество учеников на руководителя) */
calcTest.textField2.setText("15");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры) */
calcTest.textField3.setText("9");
/* Нажатие кнопки "Провести рассчет" */
calcTest.bExecute.doClick(); 
/* Проверка соответствия выходных данных с данными теста */
assertEquals(calcTest.textField4.getText(), "Ошибка ввода"); 
} 
/* Описание действий внутри метода теста (3 проверка) */
@Test 
public void test3() throws InterruptedException{ 
	/* Создание объекта класса калькулятора */
Calculator calcTest = new Calculator(); 
/* Нажатие на кнопку "Зав.Кафедрой" */
calcTest.bCathedra.doClick(); 
/* Ввод значения в первое поле (Количество учеников) */
calcTest.textField1.setText("60");
/* Ввод значения во второе поле (Количество учеников на руководителя)*/
calcTest.textField2.setText("0");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры)*/
calcTest.textField3.setText("10"); 
/* Нажатие кнопки "Провести рассчет" */
calcTest.bExecute.doClick(); 
/* Проверка соответствия выходных данных с данными теста */
assertEquals(calcTest.textField4.getText(), "Ошибка ввода"); 
} 
}