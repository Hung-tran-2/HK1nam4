<?php
$a=array(1,2,3);
foreach ($a as &$value) { }
echo implode(" ",$a),"<br>";
foreach ($a as $value) { }
echo implode(" ",$a);