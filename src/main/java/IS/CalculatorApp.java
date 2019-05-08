/* Указывается название пакета */
package IS; 

import java.awt.*; // импорт пакета
 import java.awt.event.*; //импорт пакета
 import javax.swing.*; //импорт пакета

/* Класс, который создаёт объекта класса калькулятора и делает его видимым.
  Указано, что во время выполнения метода может вызваться исключение, которое метод поручает обработать тому, кто вызывает метод*/
public class CalculatorApp { 

	public static void main(String[] args) throws InterruptedException { 
		Calculator calc = new Calculator();  
		
		/* Сделать калькулятор видимым */
		calc.setVisible(true);  

	}

}

/* Класс калькулятора, который наследует соответствующий класс  */
class Calculator extends JFrame  { 
	/* Объявление объектов соответствующего типа  */
	 JLabel label1, label2, label3, label4;
	 
	 /* Объявление объектов соответствующего типа  */
	 JButton bDean, bCathedra, bExecute ; 
	 
	 /* Объявление объектов соответствующего типа  */
	 JTextField textField1, textField2, textField3, textField4; 
	 
	 /* Объявление объекта соответствующего типа */
	 JPanel panel; 
	 
	 /*Конструктор класса, в ходе действия которого может быть брошено исключение, которое конструктор поручает обработать тому, кто вызывает конструктор */
	public Calculator() throws InterruptedException { 
		/* Название окна калькулятора */
		super("Calculator");
		
		/*При нажатии на крестик калькулятор будет полностью выключаться*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Задание размера и расположения окна */
		setBounds(370, 300, 250, 100); 
		
		/*Создание объектов*/
		label1 = new JLabel("Выберите роль пользователя"); 
		bCathedra = new JButton("Зав. кафедрой"); 
		bDean = new JButton("Декан"); 
		
		/*Создание объекта панели, указание его менеджера компоновки и добавление объектов на панель */
		panel = new JPanel(new FlowLayout());   
		panel.add(label1); 
		panel.add(bCathedra); 
		panel.add(bDean); 
		
		/* Добавление панели в окно */
		add(panel); 
		
		/* Добавление слушателя событий к соответствующей кнопке  */
		bCathedra.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent arg0) { 
				/* Очистить панель */
				panel.removeAll(); 
				
				/* Задание размера и расположения окна */
				setBounds(630, 390, 630, 200); 
				
				/* Создание объектов */
				label1 = new JLabel("Введите количество учеников"); 
				label2 = new JLabel("Введите количество учеников на руководителя (от 1 до 5)"); 
				label3 = new JLabel("Введите количество свободных руководителей с кафедры"); 
				label4 = new JLabel("Результат расчёта количества дипломных руководителей");
				
				
				textField1 = new JTextField("", 2); 
				textField2 = new JTextField("", 2); 
				textField3 = new JTextField("", 2); 
				textField4 = new JTextField("", 55); 
				
				bExecute = new JButton("Провести расчёт");
				/* Добавление слушателя событий к соответствующую кнопке  */
				bExecute.addActionListener(new ActionListener() { 
					
					public void actionPerformed(ActionEvent arg0) {
						/* Вызов метода для расчёта */
						doCount(); 
						
					}
					
				});
				
				/* Создание объектов */
				panel.add(label1); 
				panel.add(textField1); 
				panel.add(label2); 
				panel.add(textField2); 
				panel.add(label3); 
				panel.add(textField3); 
				panel.add(label4); 
				panel.add(textField4); 
				panel.add(bExecute);
				
			}
			
		});
		
		/* Добавление слушателя событий к соответствующей кнопке*/
		bDean.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e) { 
				
				/* Очистить панель */
				panel.removeAll(); 
				
				/* Поместить контейнер как недействительный и выполнить компоновку контейнера */
				panel.revalidate(); 
				
				/* Задание размера и расположения окна */
				setBounds(630, 390, 250, 120); 
				
				/* Создание объектов */
				label1 = new JLabel("Введите название кафедры"); 
				textField1 = new JTextField("", 20); 
				bExecute = new JButton("Далее"); 
				
				/* Добавление объектов на панель */
				panel.add(label1); 
				panel.add(textField1); 
				panel.add(bExecute); 
				
				/* Добавление слушателя событий к соответствующей кнопке */
				bExecute.addActionListener(new ActionListener() { 
				
					public void actionPerformed(ActionEvent arg0) { 
						/* Очистить панель */
						panel.removeAll(); 
						
						/* Задание размера и расположения окна */
						setBounds(630, 390, 630, 200); 
						
						/* Создание объектов */
						label1 = new JLabel("Введите количество учеников"); 
						label2 = new JLabel("Введите количество учеников на руководителя (от 1 до 5)"); 
						label3 = new JLabel("Введите количество свободных руководителей с кафедры"); 
						label4 = new JLabel("Результат расчёта количества дипломных руководителей");
						
						textField1 = new JTextField("", 2); 
						textField2 = new JTextField("", 2); 
						textField3 = new JTextField("", 2);
						textField4 = new JTextField("", 55); 
						
						bExecute = new JButton("Провести расчёт"); 
						
						/* Добавление слушателя событий к соответствующей кнопке*/
						bExecute.addActionListener(new ActionListener() { 
						
							public void actionPerformed(ActionEvent arg0) { 
								/* Вызов метода для расчёта */
								doCount(); 
								
							}
							
						});
						
						/* Добавление объектов на панель */
						panel.add(label1);  
						panel.add(textField1);  
						panel.add(label2);  
						panel.add(textField2);  
						panel.add(label3);  
						panel.add(textField3);  
						panel.add(label4); 
						panel.add(textField4);  
						panel.add(bExecute); 
						
					}
					
				});
			}
			
		});
	}

	
	/* Метод для расчёта */
	public void doCount(){ 
		/*Объявление переменных, значение которых вводит пользователь */
		int totalStudents = 0, studentsPerTeacher = 0, freeCathedraTeachers = 0; 
		
		 /*Объявление переменных, которые будут выведены */
		int requiredTotalTeachers = 0, requiredCathedraTeachers = 0, requiredNonCathedraTeachers = 0;
		
		/* Cделать что-то, что может вызвать исключение */
		try { 
			/* Считать значение переменной с текстовой строки */
			totalStudents = Integer.parseInt(textField1.getText()); 
			
			/*При выполнении условия вызвать исключение */
			if(totalStudents < 0) 
				throw new Exception(); 
			
			/* Считать значение переменной с текстовой строки */
			studentsPerTeacher = Integer.parseInt(textField2.getText()); 
			
			/* При выполнении условия вызвать исключение */
			if(!(studentsPerTeacher >= 1 && studentsPerTeacher <= 5)) 
				throw new Exception(); 
			
			/* Считать значение переменной с текстовой строки */
			freeCathedraTeachers = Integer.parseInt(textField3.getText()); 
			
			/* При выполнении условия вызвать исключение */
			if(freeCathedraTeachers < 0) 
				throw new Exception(); 
		}
		/* Описание того, что сделать при поимке исключения */
		catch(Exception e) { 
			/*Приравнять значение переменных к 0 и очистить содержимое текстовых строк */
			totalStudents = 0; 
			textField1.setText(""); 
			
			studentsPerTeacher = 0; 
			textField2.setText(""); 
			
			freeCathedraTeachers = 0; 
			textField3.setText(""); 
			
			/* Изменить содержимое текстовой строки */
			textField4.setText("Ошибка ввода"); 
			
			/* Возврат из метода */
			return; 
		}
		
		/* Вычисление общего количества необходимых руководителей */
		requiredTotalTeachers = totalStudents / studentsPerTeacher; 
		/*Если количество необходимых руководителей не целое, увеличить значение переменной на 1 */
		if(totalStudents % studentsPerTeacher != 0) 
			requiredTotalTeachers++; 
		
		/*Если общее количество необходимых руководителей меньше либо равно количеству свободных руководителей с кафедры,
		то  количество необходимых руководителей с кафедры равно общему количеству требуемых руководителей
		(в таком случае количество руководителей не с кафедры равно 0)*/
		if(requiredTotalTeachers <= freeCathedraTeachers) 
			requiredCathedraTeachers = requiredTotalTeachers; 
		
		/* Иначе количество необходимых руководителей с кафедры равно количеству свободных руководителей с кафедры, а  количество необходимых 
		 руководителей не с кафедры равно разности общего количества необходимых руководителей и количества свободных руководителей с кафедры */
		else { 
			requiredCathedraTeachers = freeCathedraTeachers; 
			requiredNonCathedraTeachers = requiredTotalTeachers - freeCathedraTeachers; 
		}
		/* Вывод результата */
		textField4.setText("Необходимы дипломные руководители в количестве " + requiredTotalTeachers + " чел.: " + requiredCathedraTeachers + " чел. с кафедры и " + requiredNonCathedraTeachers + " чел. не с кафедры."); 
	}
	
}
