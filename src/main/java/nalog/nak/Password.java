package nalog.nak; 
/* Импортируем:
javax.* — стандартные расширения.(Стандартные расширения (standard extensions) — это пакеты или набо-ры пакетов Java)
Swing - Библиотека графического интерфейса (конкретный пакет), В отличие от java.awt, javax.swing имеет более гибкую
систему управления и более широкий набор функций
"*"-включение всех элементов библиотеки Swing (jbutton,jpanel,jlabel и т.д.)
"." используется для выделения элементов из ссылки на объект.
*/
import javax.swing.*;
/* java. - Все стандартные классы, поставляемые с системой Java, хранятся в пакете java.
java.awt - подключение пакета awt, содержащего базовые графические функции:GridLayout, BorderLayout и т.д.
"*"-включение всех элементов библиотеки awt */
import java.awt.*; 
import java.awt.event.*; 
/*java.util.Arrays содержит статические методы*/
import java.util.Arrays; 
/* (Public) - поля и методы класса Password доступны для всех других объектов и классов.
зарезервированное слово class - говорит транслятору, что мы собираемся описать новый класс Password.
Класс наследует функции элемента JPanel, который определён в стандартной библиотеке awt.
JPanel - сама панель.
*/
public class Password extends JPanel 
/*Обработка событий*/
implements ActionListener { 
/*Обозначение переменных с типом данных string*/
private static String OK = "ok"; 
private static String HELP = "help"; 
/*Нужна для диалогов*/
private JFrame controllingFrame; 
private JPasswordField passwordField; 
public Password(JFrame f) { 
controllingFrame = f; 
/*JPasswordField компонент, который позволяет редактирование одной строки текста,
 *  где представление указывает, что что-то было введено, но не показывает исходные символы*/
passwordField = new JPasswordField(10);

passwordField.setActionCommand(OK); 
passwordField.addActionListener(this); 
/*Обозначаем что переменные label
 *  являются объектом JLabel и указываем какой текст будет выводиться.
*/
JLabel label = new JLabel("Введите пароль: "); 
/*Создание кнопок*/
JComponent buttonPane = createButtonPanel(); 
/*Создание textPane*/
JPanel textPane = new JPanel(new FlowLayout()); 
/*Добавление объекта label и passwordField в textPane*/
textPane.add(label); 
textPane.add(passwordField); 
/*Добавление объектов textPane и buttonPane */
add(textPane); 
add(buttonPane); 
} 
/*Модификатор protected — переменные, методы и конструкторы, которые объявляются как protected в классе,
 *  могут быть доступны только для подклассов в другом пакете или для любого класса в пакете класса protected.*/
protected JComponent createButtonPanel() { 
	/* установка менеджера компоновки GridLayout. данный менеджер компоновки располагает компоненты в
	таблицу */
	/* на панели 0 строк, 1 столбец*/
JPanel p = new JPanel(new GridLayout(0,1)); 
/*Обозначаем что переменные okButton,helpButton  являются объектом
 *  JButton
 *  В скобках наименование кнопок */
JButton okButton = new JButton("OK"); 
JButton helpButton = new JButton("Help"); 
/*Передаётся в переменные okButton,helpButton строковое значение */
okButton.setActionCommand(OK); 
helpButton.setActionCommand(HELP); 
okButton.addActionListener(this); 
helpButton.addActionListener(this); 
/*Добавление кнопок в p*/
p.add(okButton); 
p.add(helpButton); 
return p; 
} 
/*Обработка событий*/
public void actionPerformed(ActionEvent e) {
	/*getActionCommand() предоставляет строку, представляющую команду действия*/
String cmd = e.getActionCommand(); 
/*Если нажать на кнопку "OK"*/
if (OK.equals(cmd)) { 
char[] input = passwordField.getPassword();
/*Если выполнится условие, то будет показано окно диалога
 * с текстом "Пароль правильный" затем произойдёт вызов main1 из класса Nalog*/
if (isPasswordCorrect(input)) { 
JOptionPane.showMessageDialog(controllingFrame, 
"Пароль правильный"); 
Nalog.main1(null); 
/*Закрытие диалогового окна*/
controllingFrame.dispose(); 
} else { 
	/*Если же будет ошибка, то вызовится диалоговое окно(ошибки) с названием
	 * "Ошибка" и содержимым "Пароль не верный"*/
JOptionPane.showMessageDialog(controllingFrame, 
"Пароль не верный", 
"Ошибка", 
JOptionPane.ERROR_MESSAGE); 
} 
/*При ошибке выделяет всю строку*/
Arrays.fill(input, '0'); 
passwordField.selectAll(); 
resetFocus(); 
/*Если не нажали на кнопку "ОК", а на "Help", то вызовится диалоговое окно в котором будет
 * пароль "admin"*/
} else { 
JOptionPane.showMessageDialog(controllingFrame, 
"Пароль 'admin'"); 
} 
} 
/*boolean логический тип*/
private static boolean isPasswordCorrect(char[] input) { 
boolean isCorrect = true; 
/*Проверка на правильность введёного пароля*/
char[] correctPassword = { 'a', 'd', 'm', 'i', 'n'}; 
/*Если введённый пароль не совпадает с переменной correctPassword,
 * то выдаст сообщение об ошибке в противном случае выдаст что пароль был введён 
 * правильно */
if (input.length != correctPassword.length) { 
isCorrect = false; 
} else { 
isCorrect = Arrays.equals (input, correctPassword); 
} 
Arrays.fill(correctPassword,'0'); 
return isCorrect; 
} 

protected void resetFocus() { 
passwordField.requestFocusInWindow(); 
} 
/*Создание формы*/
private static void createAndShowGUI() { 
JFrame frame = new JFrame("Password"); 
/*по закрытию формы - не закрывать приложение в frame*/
frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
final Password newContentPane = new Password(frame); 
/*setContentPane заменяет содержимое frame на newContentPane*/
frame.setContentPane(newContentPane); 
/*Добавляет окно*/
frame.addWindowListener(new WindowAdapter() { 
public void windowActivated(WindowEvent e) { 
} 
}); 
/*Метод pack() устанавливает такой минимальный размер контейнера,
 *  который достаточен для отображения всех компонентов.*/
frame.pack(); 
frame.setVisible(true); 
} 
public static void main(String[] args) { 
SwingUtilities.invokeLater(new Runnable() { 
public void run() { 
UIManager.put("swing.boldMetal", Boolean.FALSE); 
createAndShowGUI(); 
} 
}); 
} 
}









