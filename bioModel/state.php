<?php
ini_set('session.use_trans_sid','1');
session_start();
if (isset($_POST['ok']))://проверка нажата ли кнопка
{
//переприсвоение вводных данных с формочки в переменные
	$x = $_POST['x'];
	$y = $_POST['y'];
	$r_male = $_POST ['r_male'];
	$r_fema = $_POST ['r_fema'];
	$w_male = $_POST ['w_male'];
	$w_fema = $_POST ['w_fema'];
	$eda = $_POST ['eda'];
//создание ОСТРОВА X на Y
	for($i=1;$i<=$y;$i++)
		for ($j=1;$j<=$x;$j++)
			$multable[$i][$j]="o";
//расстановка зайцов (МУЖ.)
	for($r_m=1;$r_m<=$r_male;$r_m++){
		$rand_i = rand (1,$y);
		$rand_j = rand (1,$x);
		$multable[$rand_i][$rand_j] = "-rm4";
	}
//расстановка зайцов (ЖЕН.)
	for($r_f=1;$r_f<=$r_fema;$r_f++){
		$rand_i = rand (1,$y);
		$rand_j = rand (1,$x);
		if ($multable[$rand_i][$rand_j]=="o")
		{$multable[$rand_i][$rand_j] = "-rf4";}
		else
		{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-rf4";}
	}
//расстановка волков (МУЖ.)
	for($w_m=1;$w_m<=$w_male;$w_m++){
		$rand_i = rand (1,$y);
		$rand_j = rand (1,$x);
		if ($multable[$rand_i][$rand_j]=="o")
		{$multable[$rand_i][$rand_j] = "-wm4_0.010";}
		else
		{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-wm4_0.010";}
	}
//расстановка волков (ЖЕН.)
	for($w_f=1;$w_f<=$w_fema;$w_f++){
		$rand_i = rand (1,$y);
		$rand_j = rand (1,$x);
		if ($multable[$rand_i][$rand_j]=="o")
		{$multable[$rand_i][$rand_j] = "-wf4_0.010";}
		else
		{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-wf4_0.010";}
	}
//расстановка еды
	for($e=1;$e<=$eda;$e++){
		$rand_i = rand (1,$y);
		$rand_j = rand (1,$x);
		if ($multable[$rand_i][$rand_j]=="o")
		{$multable[$rand_i][$rand_j] = "-eda";}
		else
		{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-eda";}
	}
	//Печать острова с расстановкой на 1 итерации!!!!!!
echo"<html>";
echo"<head>";
echo"<meta http-equiv='Content-Type' content='text/html' charset='utf-8' />";
echo"<meta name='description' content='Волчий остров'>";
echo"<meta name='keywords' content=''>";
echo"<title>Волчий остров</title>";
echo"</head>";
//Вывод массива
echo"<body><table>";
for ($i=1;$i<=$y;$i++)
{
	print "<tr>";
	for ($j=1;$j<=$x;$j++)
		echo "<td>"."=".$multable[$i][$j]."</td>";
	print "</tr>";
}
echo"</table>";
//Посылка масива в следующую итерацию
echo "<br><form method='post' action='iter.php'><div align='center'>";
	echo "<input type='hidden' name='x' value='".$x."'>";
	echo "<input type='hidden' name='y' value='".$y."'>";
$multo = serialize($multable);//преобразование массива
	echo "<input type = 'hidden' name = 'multo' value = '".$multo."'/>";
	echo"<input type='submit' name='ok' value='Next ITERATION'></form></br>";
	echo "На 1 итерации :".$r_male." (r_m), ".$r_fema." (r_f), ".$w_male." (w_m), ".$w_fema." (w_f)";
echo "</div></body>";
echo"</html>";
}
else:
{
	echo "Error";
}
endif
?>