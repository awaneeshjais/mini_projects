<?php
ini_set('session.use_trans_sid','1');
session_start();
if (isset($_POST['ok']))://проверка нажата ли кнопка
{
//переприсвоение переменных и массивов
$x = $_POST['x'];
$y = $_POST['y'];
$multo = $_POST['multo'];
$multable=unserialize($multo);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//функция добавления поколени у зайца (волка)
function pokol($life)
{if ($life <= 3) {return $life = $life + 1;} else {return $life;}}
//функция добавления жизни у волка при сьедании зайца
function add_life($life)
{$life = $life + 0.010; return $life;}
//функция убирания жизни у волка при ходе на одну клеточку
function del_life($life)
{$life = $life - 0.001; return $life;} 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//еда для кроликов
$e=0;
$r=0;
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		$a = $multable[$i][$j];
		$e = substr_count($multable[$i][$j], "-eda");
		$r = substr_count($multable[$i][$j], "-r");
		if (($e>=1) and ($r>=1))
			{
				if ($e<=$r)
				{
					$multable[$i][$j]=str_replace("-eda","", $a, $e);
					for ($k=1; $k<=$e; $k++) { 
					$rand_i = rand (1,$y);
					$rand_j = rand (1,$x);
					if ($multable[$rand_i][$rand_j]=="o")
					{$multable[$rand_i][$rand_j] = "-eda";}
					else
					{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-eda";}}
				}
				else 
				{
					$multable[$i][$j]=str_replace("-eda", "", $a, $r);
					for ($k=1; $k<=$r; $k++) { 
					$rand_i = rand (1,$y);
					$rand_j = rand (1,$x);
					if ($multable[$rand_i][$rand_j]=="o")
					{$multable[$rand_i][$rand_j] = "-eda";}
					else
					{$multable[$rand_i][$rand_j] = $multable[$rand_i][$rand_j]."-eda";}
					}
				}
			}
		elseif (($e>=1) and ($r==0))
			{$multable[$i][$j]=$multable[$i][$j];}
		else {$multable[$i][$j]=$multable[$i][$j];}
		
		$e=0;
		$r=0;
	}
}
//волк+волчица = 1 волченок
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		$wol_m = substr_count($multable[$i][$j], "-wm4");
		$wol_f = substr_count($multable[$i][$j], "-wf4");
		$sta = rand(1,2);
		//выбор стати
		if ($sta==1)
			$sta="m";
		else $sta="f";
		//////////////
		if (($wol_m > 0) and ($wol_m == $wol_f))
		{$multable[$i][$j] = $multable[$i][$j]."-w".$sta."1_0.010";}
		else 
		{$multable[$i][$j] = $multable[$i][$j];}
	}
}
//заяц+зайчиха = 1-5 зайчат
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		$rab_m = substr_count($multable[$i][$j], "-rm4");
		$rab_f = substr_count($multable[$i][$j], "-rf4");
		$cou = rand (1,5);
		if (($rab_m > 0) and ($rab_m == $rab_f))
		{
			for ($r=1;$r<=$cou;$r++)
			{
				//выбор стати
				$sta = rand(1,2);
				if ($sta==1)
					$sta="m";
				else $sta="f";
				//////////////
				$multable[$i][$j] = $multable[$i][$j]."-r".$sta."1";
				$sta = 0;				
			}
		}
		else 
		{$multable[$i][$j] = $multable[$i][$j];}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//хождение волка...
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		//убийство старых волков
		if (substr_count($multable[$i][$j], "-wm4_0.001") <>0) {
			$multable[$i][$j] = str_replace("-wm4_0.001", "", $multable[$i][$j]);
		}
		else {$multable[$i][$j] = $multable[$i][$j];}
		//////////////////
		if (substr_count($multable[$i][$j], "-wm") > 0)
		{
				//копир волка c kletki
				$temp = substr($multable[$i][$j], strpos($multable[$i][$j], "-wm"), 10);
				$temp_ = "-wm";
				$temp_pokol = pokol(substr($temp, 3, 1));
				//проверяем на логику сосед клетки
					//подсчет условий в соседних клетках
					$p1 = $i-1;
					$q1 = $j-1;
					$c1_wf4 = substr_count($multable[$p1][$q1], "-wf4");
					$c1_r = substr_count($multable[$p1][$q1], "-r");
					$p2 = $i-1;
					$q2 = $j;
					$c2_wf4 = substr_count($multable[$p2][$q2], "-wf4");
					$c2_r = substr_count($multable[$p2][$q2], "-r");
					$p3 = $i-1;
					$q3 = $j+1;
					$c3_wf4 = substr_count($multable[$p3][$q3], "-wf4");
					$c3_r = substr_count($multable[$p3][$q3], "-r");
					$p4 = $i;
					$q4 = $j-1;
					$c4_wf4 = substr_count($multable[$p4][$q4], "-wf4");
					$c4_r = substr_count($multable[$p4][$q4], "-r");
					$p5 = $i;
					$q5 = $j+1;
					$c5_wf4 = substr_count($multable[$p5][$q5], "-wf4");
					$c5_r = substr_count($multable[$p5][$q5], "-r");
					$p6 = $i+1;
					$q6 = $j-1;
					$c6_wf4 = substr_count($multable[$p6][$q6], "-wf4");
					$c6_r = substr_count($multable[$p6][$q6], "-r");
					$p7 = $i-1;
					$q7 = $j;
					$c7_wf4 = substr_count($multable[$p7][$q7], "-wf4");
					$c7_r = substr_count($multable[$p7][$q7], "-r");
					$p8 = $i+1;
					$q8 = $j+1;
					$c8_wf4 = substr_count($multable[$p8][$q8], "-wf4");
					$c8_r = substr_count($multable[$p8][$q8], "-r");
					//создание счетчиков для Волчиха+кроль, Волчиха, кроль
					$counter_wf4_r = "";
					$counter_wf4 = "";
					$counter_r = "";
					//в клетке еда +зая
					if ($c1_wf4>0 and $c1_r>0)
						{$counter_wf4_r = "1";}
					elseif ($c2_wf4>0 and $c2_r>0)
						{$counter_wf4_r = $counter_wf4_r."2";}
					elseif ($c3_wf4>0 and $c3_r>0)
						{$counter_wf4_r = $counter_wf4_r."3";}
					elseif ($c4_rf4>0 and $c4_r>0)
						{$counter_wf4_r = $counter_wf4_r."4";}
					elseif ($c5_rf4>0 and $c5_r>0)
						{$counter_wf4_r = $counter_wf4_r."5";}
					elseif ($c6_rf4>0 and $c6_r>0)
						{$counter_wf4_r = $counter_wf4_r."6";}
					elseif ($c7_rf4>0 and $c7_r>0)
						{$counter_wf4_r = $counter_wf4_r."7";}
					elseif ($c8_rf4>0 and $c8_r>0)
						{$counter_wf4_r = $counter_wf4_r."8";}
					//в клетке токо волчиха
					elseif ($c1_wf4>0 and $c1_r==0)
						{$counter_wf4 = $counter_wf4."1";}
					elseif ($c2_wf4>0 and $c2_r==0)
						{$counter_wf4 = $counter_wf4."2";}
					elseif ($c3_wf4>0 and $c3_r==0)
						{$counter_wf4 = $counter_wf4."3";}
					elseif ($c4_wf4>0 and $c4_r==0)
						{$counter_wf4 = $counter_wf4."4";}
					elseif ($c5_wf4>0 and $c5_r==0)
						{$counter_wf4 = $counter_wf4."5";}
					elseif ($c6_wf4>0 and $c6_r==0)
						{$counter_wf4 = $counter_wf4."6";}
					elseif ($c7_wf4>0 and $c7_r==0)
						{$counter_wf4 = $counter_wf4."7";}
					elseif ($c8_wf4>0 and $c8_r==0)
						{$counter_wf4 = $counter_wf4."8";}
					//в клетке токо еда
					elseif ($c1_wf4==0 and $c1_r>0)
						{$counter_r = $counter_r."1";}
					elseif ($c2_wf4==0 and $c2_r>0)
						{$counter_r = $counter_r."2";}
					elseif ($c3_wf4==0 and $c3_r>0)
						{$counter_r = $counter_r."3";}
					elseif ($c4_wf4==0 and $c4_r>0)
						{$counter_r = $counter_r."4";}
					elseif ($c5_wf4==0 and $c5_r>0)
						{$counter_r = $counter_r."5";}
					elseif ($c6_wf4==0 and $c6_r>0)
						{$counter_r = $counter_r."6";}
					elseif ($c7_wf4==0 and $c7_r>0)
						{$counter_r = $counter_r."7";}
					elseif ($c8_wf4==0 and $c8_r>0)
						{$counter_r = $counter_r."8";}
					else {$counter_wf4_r = "";
					$counter_wf4 = "";
					$counter_r = "";}
						//хождения волка
						if ($counter_wf4_r <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_wf4_r));
							$rand_count = substr($counter_wf4_r, $c, 1);
							switch ($rand_count) {
							case 1:
								$p1 = $i-1;
								$q1 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 2:
								$p2 = $i-1;
								$q2 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 3:
								$p3 = $i-1;
								$q3 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 4:
								$p4 = $i;
								$q4 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 5:
								$p5 = $i;
								$q5 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 6:
								$p6 = $i+1;
								$q6 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 7:
								$p7 = $i-1;
								$q7 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 8:
								$p8 = $i+1;
								$q8 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							}
						}
						elseif ($counter_wf4 <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_wf4));
							$rand_count = substr($counter_wf4, $c, 1);
							switch ($rand_count) {
							case 1:
								$p1 = $i-1;
								$q1 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 2:
								$p2 = $i-1;
								$q2 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 3:
								$p3 = $i-1;
								$q3 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 4:
								$p4 = $i;
								$q4 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 5:
								$p5 = $i;
								$q5 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 6:
								$p6 = $i+1;
								$q6 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 7:
								$p7 = $i-1;
								$q7 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 8:
								$p8 = $i+1;
								$q8 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							}
						}
						elseif ($counter_r <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_r));
							$rand_count = substr($counter_r, $c, 1);
							switch ($rand_count) {
							case 1:
								$p1 = $i-1;
								$q1 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 2:
								$p2 = $i-1;
								$q2 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 3:
								$p3 = $i-1;
								$q3 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 4:
								$p4 = $i;
								$q4 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 5:
								$p5 = $i;
								$q5 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 6:
								$p6 = $i+1;
								$q6 = $j-1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 7:
								$p7 = $i-1;
								$q7 = $j;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							case 8:
								$p8 = $i+1;
								$q8 = $j+1;
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
							break;
							}
						}
						else {
							$p=0;
							$q=0;
							$rand_i = rand(-1,1);
							$rand_j = rand(-1,1);
							$p=$i+$rand_i;
							$q=$j+$rand_j;
							if ($p>1 and $q>1 and $p<$y and $q<$x) 
								//добавляем или прибаляем жизнь волky
								if (substr_count($multable[$i][$j], "-r")>0) {
									$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
									$temp_life = add_life(substr($temp, 5, 5));
								}
								else {
									$temp_life = del_life(substr($temp, 5, 5));
								}
								//добавляем волка с +1 поколением
								$multable[$p][$q] = $multable[$p][$q].$temp_.$temp_pokol."_".$temp_life;
								//удалаем волка в текущей клетке
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wm"), 10);
						}
 		}
		else {$multable[$i][$j]=$multable[$i][$j];}
	}
}

//хождение зайца...
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		if (substr_count($multable[$i][$j], "-rm") > 0)
		{
				//убрал зайца c kletki
				$temp = substr($multable[$i][$j], strpos($multable[$i][$j], "-rm"), 4);
				$temp_ = "-rm";
				$temp_pokol = pokol(substr($temp, -1, 1));
				//проверяем на логику сосед клетки
				
					//подсчет условий в соседних клетках
					$p1 = $i-1;
					$q1 = $j-1;
					$c1_rf4 = substr_count($multable[$p1][$q1], "-rf4");
					$c1_eda = substr_count($multable[$p1][$q1], "-eda");
					$p2 = $i-1;
					$q2 = $j;
					$c2_rf4 = substr_count($multable[$p2][$q2], "-rf4");
					$c2_eda = substr_count($multable[$p2][$q2], "-eda");
					$p3 = $i-1;
					$q3 = $j+1;
					$c3_rf4 = substr_count($multable[$p3][$q3], "-rf4");
					$c3_eda = substr_count($multable[$p3][$q3], "-eda");
					$p4 = $i;
					$q4 = $j-1;
					$c4_rf4 = substr_count($multable[$p4][$q4], "-rf4");
					$c4_eda = substr_count($multable[$p4][$q4], "-eda");
					$p5 = $i;
					$q5 = $j+1;
					$c5_rf4 = substr_count($multable[$p5][$q5], "-rf4");
					$c5_eda = substr_count($multable[$p5][$q5], "-eda");
					$p6 = $i+1;
					$q6 = $j-1;
					$c6_rf4 = substr_count($multable[$p6][$q6], "-rf4");
					$c6_eda = substr_count($multable[$p6][$q6], "-eda");
					$p7 = $i-1;
					$q7 = $j;
					$c7_rf4 = substr_count($multable[$p7][$q7], "-rf4");
					$c7_eda = substr_count($multable[$p7][$q7], "-eda");
					$p8 = $i+1;
					$q8 = $j+1;
					$c8_rf4 = substr_count($multable[$p8][$q8], "-rf4");
					$c8_eda = substr_count($multable[$p8][$q8], "-eda");
					//создание счетчиков для Зая+еда, Зая, еда
					$counter_rf4_eda = "";
					$counter_rf4 = "";
					$counter_eda = "";
					//в клетке еда +зая
					if ($c1_rf4>0 and $c1_eda>0)
						{$counter_rf4_eda = "1";}
					elseif ($c2_rf4>0 and $c2_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."2";}
					elseif ($c3_rf4>0 and $c3_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."3";}
					elseif ($c4_rf4>0 and $c4_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."4";}
					elseif ($c5_rf4>0 and $c5_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."5";}
					elseif ($c6_rf4>0 and $c6_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."6";}
					elseif ($c7_rf4>0 and $c7_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."7";}
					elseif ($c8_rf4>0 and $c8_ead>0)
						{$counter_rf4_eda = $counter_rf4_eda."8";}
					//в клетке токо зая
					elseif ($c1_rf4>0 and $c1_eda==0)
						{$counter_rf4 = $counter_rf4."1";}
					elseif ($c2_rf4>0 and $c2_eda==0)
						{$counter_rf4 = $counter_rf4."2";}
					elseif ($c3_rf4>0 and $c3_eda==0)
						{$counter_rf4 = $counter_rf4."3";}
					elseif ($c4_rf4>0 and $c4_eda==0)
						{$counter_rf4 = $counter_rf4."4";}
					elseif ($c5_rf4>0 and $c5_eda==0)
						{$counter_rf4 = $counter_rf4."5";}
					elseif ($c6_rf4>0 and $c6_eda==0)
						{$counter_rf4 = $counter_rf4."6";}
					elseif ($c7_rf4>0 and $c7_eda==0)
						{$counter_rf4 = $counter_rf4."7";}
					elseif ($c8_rf4>0 and $c8_eda==0)
						{$counter_rf4 = $counter_rf4."8";}
					//в клетке токо еда
					elseif ($c1_rf4==0 and $c1_eda>0)
						{$counter_eda = $counter_eda."1";}
					elseif ($c2_rf4==0 and $c2_eda>0)
						{$counter_eda = $counter_eda."2";}
					elseif ($c3_rf4==0 and $c3_eda>0)
						{$counter_eda = $counter_eda."3";}
					elseif ($c4_rf4==0 and $c4_eda>0)
						{$counter_eda = $counter_eda."4";}
					elseif ($c5_rf4==0 and $c5_eda>0)
						{$counter_eda = $counter_eda."5";}
					elseif ($c6_rf4==0 and $c6_eda>0)
						{$counter_eda = $counter_eda."6";}
					elseif ($c7_rf4==0 and $c7_eda>0)
						{$counter_eda = $counter_eda."7";}
					elseif ($c8_rf4==0 and $c8_eda>0)
						{$counter_eda = $counter_eda."8";}
					else {$counter_rf4_eda = "";
					$counter_rf4 = "";
					$counter_eda = "";}
						//хождения заяца
						if ($counter_rf4_eda <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_rf4_eda));
							$rand_count = substr($counter_rf4_eda, $c, 1);
							switch ($rand_count) {
							case 1:
							$p1 = $i-1;
							$q1 = $j-1;
							$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 2:
							$p2 = $i-1;
							$q2 = $j;
							$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 3:
							$p3 = $i-1;
							$q3 = $j+1;
							$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 4:
							$p4 = $i;
							$q4 = $j-1;
							$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 5:
							$p5 = $i;
							$q5 = $j+1;
							$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 6:
							$p6 = $i+1;
							$q6 = $j-1;
							$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 7:
							$p7 = $i-1;
							$q7 = $j;
							$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 8:
							$p8 = $i+1;
							$q8 = $j+1;
							$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							}
						}
						elseif ($counter_rf4 <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_rf4));
							$rand_count = substr($counter_rf4, $c, 1);
							switch ($rand_count) {
							case 1:
							$p1 = $i-1;
							$q1 = $j-1;
							$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 2:
							$p2 = $i-1;
							$q2 = $j;
							$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 3:
							$p3 = $i-1;
							$q3 = $j+1;
							$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 4:
							$p4 = $i;
							$q4 = $j-1;
							$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 5:
							$p5 = $i;
							$q5 = $j+1;
							$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 6:
							$p6 = $i+1;
							$q6 = $j-1;
							$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 7:
							$p7 = $i-1;
							$q7 = $j;
							$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 8:
							$p8 = $i+1;
							$q8 = $j+1;
							$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							}
						}
						elseif ($counter_eda <> "")
						{
							$c = 0;
							$c = rand (0,strlen($counter_eda));
							$rand_count = substr($counter_eda, $c, 1);
							switch ($rand_count) {
							case 1:
							$p1 = $i-1;
							$q1 = $j-1;
							$multable[$p1][$q1] = $multable[$p1][$q1].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 2:
							$p2 = $i-1;
							$q2 = $j;
							$multable[$p2][$q2] = $multable[$p2][$q2].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 3:
							$p3 = $i-1;
							$q3 = $j+1;
							$multable[$p3][$q3] = $multable[$p3][$q3].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 4:
							$p4 = $i;
							$q4 = $j-1;
							$multable[$p4][$q4] = $multable[$p4][$q4].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 5:
							$p5 = $i;
							$q5 = $j+1;
							$multable[$p5][$q5] = $multable[$p5][$q5].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 6:
							$p6 = $i+1;
							$q6 = $j-1;
							$multable[$p6][$q6] = $multable[$p6][$q6].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 7:
							$p7 = $i-1;
							$q7 = $j;
							$multable[$p7][$q7] = $multable[$p7][$q7].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							case 8:
							$p8 = $i+1;
							$q8 = $j+1;
							$multable[$p8][$q8] = $multable[$p8][$q8].$temp_.$temp_pokol;
							$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							break;
							}
						}
						else {
							$p=0;
							$q=0;
							$rand_i = rand(-1,1);
							$rand_j = rand(-1,1);
							$p=$i+$rand_i;
							$q=$j+$rand_j;
							if ($p>1 and $q>1 and $p<$y and $q<$x) 
								{$multable[$p][$q] = $multable[$p][$q].$temp_.$temp_pokol;
								$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
							}
						}
 		}
		else {$multable[$i][$j]=$multable[$i][$j];}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//хождение волчихи...
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		//убийство старых волчиц
		if (substr_count($multable[$i][$j], "-wf4_0.001") <>0) {
			$multable[$i][$j] = str_replace("-wf4_0.001", "", $multable[$i][$j]);
		}
		else {$multable[$i][$j] = $multable[$i][$j];}
		//////////////////
		if (substr_count($multable[$i][$j], "-wf") > 0)
		{
				//убрали волчиху
				$temp = substr($multable[$i][$j], strpos($multable[$i][$j], "-wf"), 10);
				$temp_ = "-wf";
				$temp_pokol = pokol(substr($temp, 3, 1));
				//добавляем или прибаляем жизнь волчихе
				if (substr_count($multable[$i][$j], "-r")>0) {
				$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-r"), 4);
				$temp_life = add_life(substr($temp, 5, 5));
				}
				else {
					$temp_life = del_life(substr($temp, 5, 5));
				}
				//$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wf"), 10);
				//добавляем волчиху с +1 поколением
					$p=0;
					$q=0;
					$rand_i = rand(-1,1);
					$rand_j = rand(-1,1);
					$p=$i+$rand_i;
					$q=$j+$rand_j;
					if ($p>1 and $q>1 and $p<$y and $q<$x) 
						{$multable[$p][$q] = $multable[$p][$q].$temp_.$temp_pokol."_".$temp_life;
						$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-wf"), 10);
						}
					else {$multable[$i][$j] = $multable[$i][$j];}
			
 		}
		else {$multable[$i][$j]=$multable[$i][$j];}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//хождение зайчихи...
for ($i=1;$i<=$y;$i++)
{
	for ($j=1;$j<=$x;$j++)
	{
		if (substr_count($multable[$i][$j], "-rf") > 0)
		{
				//запись зайчихи в переменную
				$temp = substr($multable[$i][$j], strpos($multable[$i][$j], "-rf"), 4);
				$temp_ = "-rf";
				$temp_pokol = pokol(substr($temp, -1, 1));
				//добавляем зайчиху всоседнюю клетку с +1 поколением
					$p=0;
					$q=0;
					$rand_i = rand(-1,1);
					$rand_j = rand(-1,1);
					$p=$i+$rand_i;
					$q=$j+$rand_j;
					if ($p>1 and $q>1 and $p<$y and $q<$x) 
						{$multable[$p][$q] = $multable[$p][$q].$temp_.$temp_pokol;
						$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rf"), 4);
						}
					else {$multable[$i][$j] = $multable[$i][$j];}
 		}
		else {$multable[$i][$j]=$multable[$i][$j];}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* ШАБЛОН
				//добавляем тело  в сосед клуткус +1 поколением
					$p=0;
					$q=0;
					$rand_i = rand(-1,1);
					$rand_j = rand(-1,1);
					$p=$i+$rand_i;
					$q=$j+$rand_j;
					if ($p>1 and $q>1 and $p<$y and $q<$x) 
						{$multable[$p][$q] = $multable[$p][$q].$temp_.$temp_pokol;
						$multable[$i][$j] = substr_replace($multable[$i][$j], "", strpos($multable[$i][$j], "-rm"), 4);
						}
					else {$multable[$i][$j] = $multable[$i][$j];}
*/

//блок подсчета остатков
$r_m=0;
$r_f=0;
$w_m=0;
$w_f=0;
$e_d=0;
$r_m = substr_count(http_build_query($multable),"rm");
$r_f = substr_count(http_build_query($multable),"rf");
$w_m = substr_count(http_build_query($multable),"wm");
$w_f = substr_count(http_build_query($multable),"wf");
$e_d = substr_count(http_build_query($multable),"eda");
/////////////////////////////////////////////
//Печать острова с расстановкой на следующей итерации!!!!!!
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
	/*echo "<input type='hidden' name='r_male' value='".$r_male."'>";
	echo "<input type='hidden' name='r_fema' value='".$r_fema."'>";
	echo "<input type='hidden' name='w_male' value='".$w_male."'>";
	echo "<input type='hidden' name='w_fema' value='".$w_fema."'>";*/
$multo = serialize($multable);//преобразование массива
	echo "<input type = 'hidden' name = 'multo' value = '".$multo."'/>";
	echo"<input type='submit' name='ok' value='Next ITERATION'></form><br>";
//Вывод значений на итерации
echo "На ЭТОЙ итерации осталось:".$r_m." (r_m), ".$r_f." (r_f), ".$w_m." (w_m), ".$w_f." (w_f), ".$e_d."(eda) !!!!";
//print_r ($multable);
echo "</div></body>";
echo"</html>";
}
else:
{
	echo "Error";
}
endif
?>