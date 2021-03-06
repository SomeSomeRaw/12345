/* Импорт основного пакета */
package IS; 
/* Импорт пакетов, необходимых для работы тестов */
import org.junit.Test; 

import junit.framework.TestCase; 
/* Объявляем класс второго теста для проверки работы программы */
public class KalaevTestCalculatorApp2 extends TestCase { 
/* Описание действий внутри метода теста (1 проверка) */
@Test 
public void test() throws InterruptedException{ 
/* Создание объекта класса калькулятора */
Calculator calcTest = new Calculator(); 
/* Нажатие на кнопку "Зав.Кафедрой" */
calcTest.bCathedra.doClick(); 
/* Ввод значения в первое поле (Количество учеников)*/
calcTest.textField1.setText("75"); 
/* Ввод значения во второе поле */
calcTest.textField2.setText("2");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры)*/
calcTest.textField3.setText("20"); 
/* Нажатие кнопки "Провести рассчет" */
calcTest.bExecute.doClick(); 
/* Проверка соответствия выходных данных с данными теста */
assertEquals(calcTest.textField4.getText(), "Необходимы дипломные руководители в количестве 38 чел.: 20 чел. с кафедры и 18 чел. не с кафедры."); 
} 
/* Описание действий внутри метода теста (2 проверка) */
@Test 
public void test2() throws InterruptedException{ 
/* Создание объекта класса калькулятора */
Calculator calcTest = new Calculator(); 
/* Нажатие на кнопку "Зав. Кафедрой" */
calcTest.bCathedra.doClick(); 
/* Ввод значения в первое поле (Количество учеников)*/
calcTest.textField1.setText("4");
/* Ввод значения во второе поле (Количество учеников на руководителя) */
calcTest.textField2.setText("15");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры)*/
calcTest.textField3.setText("-1");
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
/* Ввод значения в первое поле (Количество учеников)*/
calcTest.textField1.setText("34");
/* Ввод значения во второе поле (Количество учеников на руководителя)*/
calcTest.textField2.setText("10");
/* Ввод значения в третье поле (Количество свободных руководителей с кафедры) */
calcTest.textField3.setText("w"); 
/* Нажатие кнопки "Провести рассчет" */
calcTest.bExecute.doClick(); 
/* Проверка соответствия выходных данных с данными теста */
assertEquals(calcTest.textField4.getText(), "Ошибка ввода"); 
} 
}